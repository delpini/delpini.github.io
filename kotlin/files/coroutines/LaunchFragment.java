package com.dmytrodanylyk.examples;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.dmytrodanylyk.C0362R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/dmytrodanylyk/examples/LaunchFragment;", "Landroid/support/v4/app/Fragment;", "()V", "dataProvider", "Lcom/dmytrodanylyk/examples/LaunchFragment$DataProvider;", "job", "Lkotlinx/coroutines/Job;", "uiDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "hideLoading", "", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "showLoading", "showText", "data", "", "Companion", "DataProvider", "app_debug"}, k = 1, mv = {1, 1, 13})
/* compiled from: LaunchFragment.kt */
public final class LaunchFragment extends Fragment {
    public static final Companion Companion = new Companion();
    @NotNull
    public static final String TAG = "LaunchFragment";
    private HashMap _$_findViewCache;
    private final DataProvider dataProvider = new DataProvider(null, 1, null);
    private Job job;
    private final CoroutineDispatcher uiDispatcher = Dispatchers.getMain();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcom/dmytrodanylyk/examples/LaunchFragment$Companion;", "", "()V", "TAG", "", "app_debug"}, k = 1, mv = {1, 1, 13})
    /* compiled from: LaunchFragment.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/dmytrodanylyk/examples/LaunchFragment$DataProvider;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "loadData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {1, 1, 13})
    /* compiled from: LaunchFragment.kt */
    public static final class DataProvider {
        private final CoroutineDispatcher dispatcher;

        public DataProvider() {
            this(null, 1, null);
        }

        public DataProvider(@NotNull CoroutineDispatcher dispatcher) {
            Intrinsics.checkParameterIsNotNull(dispatcher, "dispatcher");
            this.dispatcher = dispatcher;
        }

        public /* synthetic */ DataProvider(CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                coroutineDispatcher = Dispatchers.getIO();
            }
            this(coroutineDispatcher);
        }

        @Nullable
        public final Object loadData(@NotNull Continuation<? super String> continuation) {
            return BuildersKt.withContext(this.dispatcher, new LaunchFragment$DataProvider$loadData$2(null), continuation);
        }
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.job = JobKt.Job$default(null, 1, null);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        return inflater.inflate(C0362R.layout.fragment_button, container, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((Button) _$_findCachedViewById(C0362R.id.button)).setOnClickListener(new LaunchFragment$onViewCreated$1(this));
    }

    public void onDestroyView() {
        super.onDestroyView();
        Job job = this.job;
        if (job == null) {
            Intrinsics.throwUninitializedPropertyAccessException("job");
        }
        job.cancel();
        _$_clearFindViewByIdCache();
    }

    private final Job loadData() {
        CoroutineScope coroutineScope = GlobalScope.INSTANCE;
        CoroutineDispatcher coroutineDispatcher = this.uiDispatcher;
        Job job = this.job;
        if (job == null) {
            Intrinsics.throwUninitializedPropertyAccessException("job");
        }
        return BuildersKt.launch$default(coroutineScope, coroutineDispatcher.plus(job), null, new LaunchFragment$loadData$1(this, null), 2, null);
    }

    private final void showLoading() {
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C0362R.id.progressBar);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "progressBar");
        progressBar.setVisibility(0);
    }

    private final void hideLoading() {
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C0362R.id.progressBar);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "progressBar");
        progressBar.setVisibility(8);
    }

    private final void showText(String data) {
        TextView textView = (TextView) _$_findCachedViewById(C0362R.id.textView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textView");
        textView.setText(data);
    }
}
