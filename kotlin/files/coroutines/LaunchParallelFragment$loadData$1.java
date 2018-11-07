package com.dmytrodanylyk.examples;

import kotlin.Metadata;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "com/dmytrodanylyk/examples/LaunchParallelFragment$loadData$1", f = "LaunchParallelFragment.kt", i = {0, 0, 1, 1}, l = {45, 52, 53}, m = "invokeSuspend", n = {"result1", "result2", "result1", "result2"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: LaunchParallelFragment.kt */
final class LaunchParallelFragment$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ LaunchParallelFragment this$0;

    LaunchParallelFragment$loadData$1(LaunchParallelFragment launchParallelFragment, Continuation continuation) {
        this.this$0 = launchParallelFragment;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        Continuation launchParallelFragment$loadData$1 = new LaunchParallelFragment$loadData$1(this.this$0, continuation);
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        launchParallelFragment$loadData$1.p$ = (CoroutineScope) obj;
        return launchParallelFragment$loadData$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LaunchParallelFragment$loadData$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object result) {
        Deferred result1;
        Deferred result2;
        Object await;
        Deferred result22;
        StringBuilder result23;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                if (!(result instanceof Failure)) {
                    CoroutineScope coroutineScope = this.p$;
                    this.this$0.showLoading();
                    result1 = BuildersKt.async$default(coroutineScope, null, null, new LaunchParallelFragment$loadData$1$result1$1(this, null), 3, null);
                    result2 = BuildersKt.async$default(coroutineScope, null, null, new LaunchParallelFragment$loadData$1$result2$1(this, null), 3, null);
                    StringBuilder stringBuilder = new StringBuilder();
                    this.L$0 = result1;
                    this.L$1 = result2;
                    this.L$2 = stringBuilder;
                    this.label = 1;
                    await = result1.await(this);
                    if (await != coroutine_suspended) {
                        StringBuilder stringBuilder2 = stringBuilder;
                        result22 = result2;
                        result23 = stringBuilder2;
                        break;
                    }
                    return coroutine_suspended;
                }
                throw ((Failure) result).exception;
            case 1:
                result23 = (StringBuilder) this.L$2;
                result22 = this.L$1;
                Deferred result12 = this.L$0;
                if (!(result instanceof Failure)) {
                    result1 = result12;
                    await = result;
                    break;
                }
                throw ((Failure) result).exception;
            case 2:
                String data = (StringBuilder) this.L$2;
                result2 = this.L$1;
                result22 = this.L$0;
                if (!(result instanceof Failure)) {
                    await = result;
                    break;
                }
                throw ((Failure) result).exception;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        result23.append((String) await);
        result23.append('\n');
        this.L$0 = result1;
        this.L$1 = result22;
        this.L$2 = result23;
        this.label = 2;
        await = result22.await(this);
        if (await == coroutine_suspended) {
            return coroutine_suspended;
        }
        data = result23;
        result2 = result22;
        data.append((String) await);
        this.this$0.showText(data.toString());
        this.this$0.hideLoading();
        return Unit.INSTANCE;
    }
}
