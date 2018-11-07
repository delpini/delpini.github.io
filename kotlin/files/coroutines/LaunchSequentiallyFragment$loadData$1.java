package com.dmytrodanylyk.examples;

import com.dmytrodanylyk.examples.LaunchSequentiallyFragment.DataProvider;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "com/dmytrodanylyk/examples/LaunchSequentiallyFragment$loadData$1", f = "LaunchSequentiallyFragment.kt", i = {1}, l = {45, 49, 52}, m = "invokeSuspend", n = {"result1"}, s = {"L$0"})
/* compiled from: LaunchSequentiallyFragment.kt */
final class LaunchSequentiallyFragment$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ LaunchSequentiallyFragment this$0;

    LaunchSequentiallyFragment$loadData$1(LaunchSequentiallyFragment launchSequentiallyFragment, Continuation continuation) {
        this.this$0 = launchSequentiallyFragment;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        Continuation launchSequentiallyFragment$loadData$1 = new LaunchSequentiallyFragment$loadData$1(this.this$0, continuation);
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        launchSequentiallyFragment$loadData$1.p$ = (CoroutineScope) obj;
        return launchSequentiallyFragment$loadData$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LaunchSequentiallyFragment$loadData$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object result) {
        String result1;
        String str;
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
                result1 = access$getDataProvider$p.loadData(this);
                if (result1 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                if (!(result instanceof Failure)) {
                    result1 = result;
                    break;
                }
                throw ((Failure) result).exception;
            case 2:
                coroutine_suspended = this.L$0;
                if (!(result instanceof Failure)) {
                    str = result;
                    break;
                }
                throw ((Failure) result).exception;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        result1 = result1;
        LaunchSequentiallyFragment launchSequentiallyFragment = this.this$0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("result1=");
        stringBuilder.append(result1);
        launchSequentiallyFragment.showText(stringBuilder.toString());
        DataProvider access$getDataProvider$p2 = this.this$0.dataProvider;
        this.L$0 = result1;
        this.label = 2;
        str = access$getDataProvider$p2.loadData(this);
        if (str == coroutine_suspended) {
            return coroutine_suspended;
        }
        coroutine_suspended = result1;
        result1 = str;
        launchSequentiallyFragment = this.this$0;
        stringBuilder = new StringBuilder();
        stringBuilder.append(coroutine_suspended);
        stringBuilder.append('\n');
        stringBuilder.append(result1);
        launchSequentiallyFragment.showText(stringBuilder.toString());
        this.this$0.hideLoading();
        return Unit.INSTANCE;
    }
}
