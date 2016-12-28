package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.newsdemo.R;
import com.bwie.newsdemo.adapter.TABAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */

public class HomeFragment extends Fragment {

    private View view;
    private ViewPager mViewPager;
    private TabLayout home_tabLayout;
    private List<Fragment> mHomeFragments;
    private String[] mTitles = new String[]{"推荐","热点","视屏","北京","社会","娱乐","问答","图片","科技","汽车","体育","财经","军事","国际","段子","趣图","美女","健康","正能量","特卖","房产","达人"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.homefragment1, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewPager = (ViewPager) view.findViewById(R.id.home_tab_viewPager);
        home_tabLayout = (TabLayout) view.findViewById(R.id.home_tabLayout);
        //添加带有导航性质的fragment
        initData();
        //设置适配器
        initView();
    }

    private void initView() {
        TABAdapter tabAdapter = new TABAdapter(getActivity().getSupportFragmentManager(),mHomeFragments,mTitles);
        //设置预加载的页面
        mViewPager.setOffscreenPageLimit(5);
        //刷新适配器
        mViewPager.setAdapter(tabAdapter);
        //设置导航模式
        home_tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //设置连接
        home_tabLayout.setupWithViewPager(mViewPager);
    }

    private void initData() {
        mHomeFragments = new ArrayList<>();
        for(int i = 0; i<mTitles.length;i++){
            Home_TAD_Fragment htf = new Home_TAD_Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("tag",mTitles[i]);
            htf.setArguments(bundle);
            mHomeFragments.add(htf);
        }
    }
}
