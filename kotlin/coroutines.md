# Kotlin Coroutine

* https://kotlinlang.org/docs/reference/coroutines-overview.html
* https://github.com/Kotlin/kotlinx.coroutines

10월 말에 [coroutines 1.0.0가 릴리즈](https://github.com/Kotlin/kotlinx.coroutines/releases/tag/1.0.0)되었으며, kotlin 1.3.0과 의존성이 있습니다.

## 설정하기

[core](https://github.com/Kotlin/kotlinx.coroutines/blob/master/core/kotlinx-coroutines-core/README.md)와 [android](https://github.com/Kotlin/kotlinx.coroutines/blob/master/ui/kotlinx-coroutines-android/README.md) 라이브러리 등을 제공합니다.
* ui > android : 
Provides Dispatchers.Main context for Android applications.

### build.gradle
#### Project
```gradle
buildscript {
    ...
    ext.kotlin_version = '1.3.0'
    ...
}
```
#### app
```gradle
dependencies {
    ...
    // coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.0"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.0"
    ...
}
```

## 사용하기
Source : https://github.com/dmytrodanylyk/coroutine-recipes

### suspend
> Kotlin의 Coroutine은 suspend 키워드로 마킹된 함수를 CPS(Continuation Passing Style)로 변환하고, 이를 Coroutine Builder를 통해 적절한 스레드 상에서 시나리오에 따라 동작하도록 구성됩니다.

```kotlin
class DataProvider(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    suspend fun loadData(): String = withContext(dispatcher) {
        delay(TimeUnit.SECONDS.toMillis(2)) // imitate long running operation
        "Data is available: ${Random().nextInt()}"
    }
}
```
#### Basic
```kotlin
private fun loadData() = GlobalScope.launch(uiDispatcher + job) {
    showLoading() // ui thread

    val result = dataProvider.loadData() // non ui thread, suspend until finished

    showText(result) // ui thread
    hideLoading() // ui thread
}
```

위의 코드를 디컴파일 하면 아래와 같습니다.

```java
@Nullable
public final Object invokeSuspend(@NotNull Object result) {
    String loadData;
    String coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    switch (this.label) {
        case 0:
            if (result instanceof Failure) {
                throw ((Failure) result).exception;
            }
            CoroutineScope coroutineScope = this.p$;
            this.this$0.showLoading();
            DataProvider access$getDataProvider$p = this.this$0.dataProvider;
            this.label = 1;
            loadData = access$getDataProvider$p.loadData(this);
            if (loadData == coroutine_suspended) {
                return coroutine_suspended;
            }
            break;
        case 1:
            if (!(result instanceof Failure)) {
                loadData = result;
                break;
            }
            throw ((Failure) result).exception;
        default:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
    this.this$0.showText(loadData);
    this.this$0.hideLoading();
    return Unit.INSTANCE;
}
```
* [LaunchFragment.java](files/coroutines/LaunchFragment.java)
* [LaunchFragment$loadData$1.java](files/coroutines/LaunchFragment$loadData$1.java)
* [LaunchFragment$DataProvider$loadData$2.java](files/coroutines/LaunchFragment$DataProvider$loadData$2.java)

#### Sequentially
```kotlin
private fun loadData() = GlobalScope.launch(uiDispatcher + job) {
    showLoading()

    val result1 = dataProvider.loadData()
    val result2 = dataProvider.loadData()

    showText("$result1\n$result2")
    hideLoading()
}
```

* [LaunchSequentiallyFragment$loadData$1.java](files/coroutines/LaunchSequentiallyFragment$loadData$1.java)
* [LaunchSequentiallyFragment$DataProvider$loadData$2.java](files/coroutines/LaunchSequentiallyFragment$DataProvider$loadData$2.java)

#### Parallel (async)
```kotlin
private fun loadData() = GlobalScope.launch(uiDispatcher + job) {
    showLoading()

    val result1 = async { dataProvider.loadData() }
    val result2 = async { dataProvider.loadData() }

    val data = "${result1.await()}\n${result2.await()}"
    showText(data)
    hideLoading()
}
```
async는 Defered를 반환합니다. Defered은 light-weight non-blocking future로 결과를 전달하며, await()을 사용하면 최종 결과를 얻을 수 있습니다.
Deferred는 또한 Job이기 때문에 필요할 경우 취소가 가능합니다.

* [LaunchParallelFragment$loadData$1.java](files/coroutines/LaunchParallelFragment$loadData$1.java)
* [LaunchParallelFragment$loadData$1$result1$1.java](files/coroutines/LaunchParallelFragment$loadData$1$result1$1.java)
* [LaunchParallelFragment$loadData$1$result1$2.java](files/coroutines/LaunchParallelFragment$loadData$1$result1$2.java)
* [LaunchSequentiallyFragment$DataProvider$loadData$2.java](files/coroutines/LaunchSequentiallyFragment$DataProvider$loadData$2.java)

## 참고
* https://medium.com/@kimtaesoo188/kotlin-weekly-63-android-coroutine-recipes-e077cb5f3d97
* https://medium.com/til-kotlin-ko/kotlin%EC%9D%98-coroutine%EC%9D%80-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%8F%99%EC%9E%91%ED%95%98%EB%8A%94%EA%B0%80-789291da6a50


# Unity(C#)의 Coroutine은?

[Unity C#의 코루틴](https://docs.unity3d.com/kr/2017.4/Manual/Coroutines.html)은 매 프레임마다 처리되는 UI (게임 프레임)과 비동기 작업들을 처리하기 위해 사용됩니다.

> 코루틴은 실행을 중지하여 Unity에 제어권을 돌려주고, 그러나 계속할 때는 다음 프레임에서 중지한 곳부터 실행을 계속할 수 있는 기능입니다.

## Example

```C#
void Fade() {
    for (float f = 1f; f >= 0; f -= 0.1f) {
        Color c = renderer.material.color;
        c.a = f;
        renderer.material.color = c;
    }
}
```
위의 Fade out 메소드가 호출될 경우, Fade out 효과가 순식간에 처리되어, 서서히 감소되는 효과를 얻을 수 없습니다.

```C#
IEnumerator Fade() {
    for (float f = 1f; f >= 0; f -= 0.1f) {
        Color c = renderer.material.color;
        c.a = f;
        renderer.material.color = c;
        yield return new WaitForSeconds(.1f);
    }
}

void Update() {
    if (Input.GetKeyDown("f")) {
        StartCoroutine("Fade");
    }
    // do something...
}
```

위의 코드에서 Update는 매 프레임 마다 호출되며, Fade() 함수 내부의 **yield**를 통해 유니티에 제어권을 돌려주고, 다음 프레임에서 중지한 곳 부터 실행할 수 있습니다.

### WWW
```CSharp
// Get the latest webcam shot from outside "Friday's" in Times Square
using UnityEngine;
using System.Collections;

public class ExampleClass : MonoBehaviour
{
    public string url = "http://images.earthcam.com/ec_metros/ourcams/fridays.jpg";
    IEnumerator Start()
    {
        using (WWW www = new WWW(url))
        {
            yield return www;
            Renderer renderer = GetComponent<Renderer>();
            renderer.material.mainTexture = www.texture;
        }
    }
}
```

## yield
유니티에서 지원하는 yield는 아래와 같습니다.

|Return|Description|
|--|--|
|yield return null|다음 프레임까지 대기|
|yield return new WaitForSeconds(float)|지정된 초 만큼 대기|
|yield return new WaitForFixedUpdate()|다음 물리 프레임까지 대기|
|yield return new WaitForEndOfFrame()|모든 렌더링작업이 끝날 때까지 대기|
|yield return StartCoRoutine(string)|다른 코루틴이 끝날 때까지 대기|
|yield return new WWW(string)|웹 통신 작업이 끝날 때까지 대기|
|yield return new AsyncOperation|비동기 작업이 끝날 때까지 대기 ( 씬로딩 )|
|yield return new WaitUntil (System.Func<Bool> predicate)|특정 조건식이 성공(true)할때까지 대기|
|yield return new WaitWhile(System.Func<Bool> predicate)|WaitUntil과 동일하지만, false가 될때까지 대기|