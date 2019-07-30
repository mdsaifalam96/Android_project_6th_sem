package Saif.Learning.core.dashboard.transactional;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import Saif.Learning.R;
import Saif.Learning.adapter.HistoryAdapter;
import Saif.Learning.models.History;
import Saif.Learning.models.ResponseHistory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransactionalFragment extends Fragment implements TransactionalView {
    private List<History> histories;
    private TransactionalPresenter presenter;

    @BindView(R.id.history_list)
    RecyclerView history_list;
    @BindView(R.id.history_loading)
    ProgressBar history_loading;

    public TransactionalFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transactional, container, false);
        ButterKnife.bind(this, view);
        initComponent(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.loadHistory();
    }

    private void initComponent(View view) {
        presenter   = new TransactionalPresenter(this);
        histories   = new ArrayList<>();

        history_list.setLayoutManager(new LinearLayoutManager(getContext()));
        history_list.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    public void loadHistory(ResponseHistory history) {
        if (history.getStatus().booleanValue()){
            histories   = history.getHistory();
            history_list.setAdapter(new HistoryAdapter(getContext(), histories, R.layout.item_history));
        }else{
            Toast.makeText(getActivity(), "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void loadHistoryError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        history_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        history_loading.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroyData();
    }
}
