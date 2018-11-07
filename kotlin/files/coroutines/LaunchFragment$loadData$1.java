package com.dmytrodanylyk.examples;

import com.dmytrodanylyk.examples.LaunchFragment.DataProvider;
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
@DebugMetadata(c = "com/dmytrodanylyk/examples/LaunchFragment$loadData$1", f = "LaunchFragment.kt", i = {}, l = {45, 50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LaunchFragment.kt */
final class LaunchFragment$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    private CoroutineScope p$;
    final /* synthetic */ LaunchFragment this$0;

    LaunchFragment$loadData$1(LaunchFragment launchFragment, Continuation continuation) {
        this.this$0 = launchFragment;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        Continuation launchFragment$loadData$1 = new LaunchFragment$loadData$1(this.this$0, continuation);
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        launchFragment$loadData$1.p$ = (CoroutineScope) obj;
        return launchFragment$loadData$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LaunchFragment$loadData$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

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
}
