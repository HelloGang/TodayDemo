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

public class VideoFragment extends Fragment {

    private View view;
    private TabLayout video_tab_layout;
    private ViewPager video_tab_viewPager;
    String[] mVideoTitle = new String[]{"推荐","音乐","搞笑","社会","小品","生活","影视","娱乐","呆萌","游戏","原创","开眼","再看一遍","火山直播"};
    private List<Fragment> mFragments;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.videofragment, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        video_tab_layout = (TabLayout) view.findViewById(R.id.video_tab_layout);
        video_tab_viewPager =  (ViewPager) view.findViewById(R.id.video_tab_viewPager);
        initData();
        initView();
    }

    private void initView() {
        //设置适配器
        TABAdapter adapter = new TABAdapter(getActivity().getSupportFragmentManager(),mFragments,mVideoTitle);
        video_tab_viewPager.setOffscreenPageLimit(5);
        video_tab_viewPager.setAdapter(adapter);
        video_tab_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
        video_tab_layout.setupWithViewPager(video_tab_viewPager);
    }

    //往集合中传递东西的方法
    private void initData() {
        mFragments = new ArrayList<>();
        for(int i =0;i<mVideoTitle.length;i++){
            Video_Tab_Fragment vtf = new Video_Tab_Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("tag",mVideoTitle[i]);
            vtf.setArguments(bundle);
            mFragments.add(vtf);
        }
    }
}
