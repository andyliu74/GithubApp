package com.anly.githubapp.di.component;

import dagger.Component;
import com.anly.githubapp.di.PerActivity;
import com.anly.githubapp.di.module.ActivityModule;
import com.anly.githubapp.di.module.DoctorListModule;
import com.anly.githubapp.di.module.RepoModule;
import com.anly.githubapp.di.module.TrendingRepoModule;
import com.anly.githubapp.ui.module.repo.DoctorListFragment;
import com.anly.githubapp.ui.module.repo.MostStarFragment;
import com.anly.githubapp.ui.module.repo.TrendingFragment;


@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class,
                RepoModule.class,
                TrendingRepoModule.class,
                DoctorListModule.class
        }
)
public interface MainComponent extends ActivityComponent {

    void inject(MostStarFragment mostStarFragment);

    void inject(TrendingFragment trendingFragment);

    void inject(DoctorListFragment doctorListFragment);

}
