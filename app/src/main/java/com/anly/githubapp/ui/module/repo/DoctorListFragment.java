package com.anly.githubapp.ui.module.repo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anly.githubapp.R;
import com.anly.githubapp.data.model.Doctor;
import com.anly.githubapp.di.component.MainComponent;
import com.anly.githubapp.presenter.main.DoctorListPresenter;
import com.anly.githubapp.ui.base.BaseFragment;
import com.anly.githubapp.ui.module.repo.adapter.DoctorListAdapter;
import com.anly.mvp.lce.LceView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple subclass.
 */
public class DoctorListFragment extends BaseFragment implements LceView<ArrayList<Doctor>> {


    @BindView(R.id.doctor_list)
    RecyclerView mDoctorListView;

    @BindView(R.id.doctor_layout)
    SwipeRefreshLayout mDoctorLayout;

    private DoctorListAdapter mAdapter;

    @Inject
    DoctorListPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(MainComponent.class).inject(this);
        mPresenter.attachView(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.loadDoctorList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor_list, null);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    private void initViews() {
        getActivity().setTitle(R.string.doctor);

        mDoctorLayout.setOnRefreshListener(mRefreshListener);

        mAdapter = new DoctorListAdapter(null);
        mAdapter.setOnRecyclerViewItemClickListener(mItemClickListener);

        mDoctorListView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mDoctorListView.addItemDecoration(new HorizontalDividerItemDecoration
                .Builder(getContext())
                .color(Color.TRANSPARENT)
                .size(getResources().getDimensionPixelSize(R.dimen.divider_height))
                .build());
        mDoctorListView.setAdapter(mAdapter);
    }

    private BaseQuickAdapter.OnRecyclerViewItemClickListener mItemClickListener = new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
//            Doctor repo = mAdapter.getItem(position);
//            RepoDetailActivity.launch(getActivity(), repo.getOwner().getLogin(), repo.getName());
        }
    };

    @Override
    public void showLoading() {
        mDoctorLayout.post(new Runnable() {
            @Override
            public void run() {
                mDoctorLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void dismissLoading() {
        mDoctorLayout.setRefreshing(false);
    }

    @Override
    public void showContent(ArrayList<Doctor> data) {
        if (data != null) {
            mAdapter.setNewData(data);
        }
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showEmpty() {

    }

    // default is java
    private SwipeRefreshLayout.OnRefreshListener mRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mPresenter.loadDoctorList();
        }
    };
}
