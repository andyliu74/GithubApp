package com.anly.githubapp.ui.module.repo.adapter;

import com.anly.githubapp.R;
import com.anly.githubapp.common.util.StringUtil;
import com.anly.githubapp.data.model.Doctor;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/***
 * Created by 000 on 2017/9/22.
 */

public class DoctorListAdapter extends BaseQuickAdapter<Doctor> {

    public DoctorListAdapter(List<Doctor> data) {
        super(R.layout.item_repo, data);
    }
    @Override
    protected void convert(BaseViewHolder baseViewHolder, Doctor doctor) {
        baseViewHolder.setText(R.id.name, StringUtil.replaceAllBlank(doctor.getName()));
        baseViewHolder.setText(R.id.desc, StringUtil.replaceAllBlank(doctor.getDesc()));
    }
}
