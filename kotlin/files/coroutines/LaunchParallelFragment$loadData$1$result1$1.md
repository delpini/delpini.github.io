```java
package com.dmytrodanylyk.examples;

import com.dmytrodanylyk.examples.LaunchParallelFragment.DataProvider;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "com/dmytrodanylyk/examples/LaunchParallelFragment$loadData$1$result1$1", f = "LaunchParallelFragment.kt", i = {}, l = {48, 48}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LaunchParallelFragment.kt */
final class LaunchParallelFragment$loadData$1$result1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    private CoroutineScope p$;
    final /* synthetic */ LaunchParallelFragment$loadData$1 this$0;

    LaunchParallelFragment$loadData$1$result1$1(LaunchParallelFragment$loadData$1 launchParallelFragment$loadData$1, Continuation continuation) {
        this.this$0 = launchParallelFragment$loadData$1;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        Continuation launchParallelFragment$loadData$1$result1$1 = new LaunchParallelFragment$loadData$1$result1$1(this.this$0, continuation);
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        launchParallelFragment$loadData$1$result1$1.p$ = (CoroutineScope) obj;
        return launchParallelFragment$loadData$1$result1$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LaunchParallelFragment$loadData$1$result1$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object result) {
        Object loadData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                if (result instanceof Failure) {
                    throw ((Failure) result).exception;
                }
                CoroutineScope coroutineScope = this.p$;
                DataProvider access$getDataProvider$p = this.this$0.this$0.dataProvider;
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
        return loadData;
    }
}
```