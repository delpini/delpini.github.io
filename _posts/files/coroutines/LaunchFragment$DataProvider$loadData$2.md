```java
package com.dmytrodanylyk.examples;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "com/dmytrodanylyk/examples/LaunchFragment$DataProvider$loadData$2", f = "LaunchFragment.kt", i = {}, l = {68, 70}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LaunchFragment.kt */
final class LaunchFragment$DataProvider$loadData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    private CoroutineScope p$;

    LaunchFragment$DataProvider$loadData$2(Continuation continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        Continuation launchFragment$DataProvider$loadData$2 = new LaunchFragment$DataProvider$loadData$2(continuation);
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        launchFragment$DataProvider$loadData$2.p$ = (CoroutineScope) obj;
        return launchFragment$DataProvider$loadData$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LaunchFragment$DataProvider$loadData$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                if (result instanceof Failure) {
                    throw ((Failure) result).exception;
                }
                CoroutineScope coroutineScope = this.p$;
                long toMillis = TimeUnit.SECONDS.toMillis(2);
                this.label = 1;
                if (DelayKt.delay(toMillis, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                if (!(result instanceof Failure)) {
                    break;
                }
                throw ((Failure) result).exception;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Data is available: ");
        stringBuilder.append(new Random().nextInt());
        return stringBuilder.toString();
    }
}
```