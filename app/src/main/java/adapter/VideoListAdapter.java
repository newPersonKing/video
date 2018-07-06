package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gy.video.R;

import java.util.ArrayList;
import java.util.List;

import mode.VideoInfor;


/**
 * Created by sujizhong on 16/6/30.
 */
public class VideoListAdapter extends BaseAdapter {

    private class ViewHodler {
        TextView mText_VideoTitle;
    }

    private List<VideoInfor> mLists = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public VideoListAdapter(Context cxt) {
        mLayoutInflater = LayoutInflater.from(cxt);
    }

    public void setData(List<VideoInfor> data) {
        mLists.clear();
        String[] str = {"课后练习题", "国务院关于加快发展现代保险服务业的若干意见"};
        String[] path = {"http://download.yxybb.com/bbvideo/web/d1/d13/d11/d1/f11-web.mp4", "http://download.yxybb.com/bbvideo/web/d1/d13/d2/d1/f1-web.mp4"};
        for (int i = 0; i < 2; i++) {
            VideoInfor videoInfor = new VideoInfor();
            videoInfor.videoPath = path[i];
            videoInfor.videoTitle = str[i];
            mLists.add(videoInfor);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mLists != null ? mLists.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mLists != null ? mLists.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.video_item, null);
            viewHodler = new ViewHodler();
            viewHodler.mText_VideoTitle = (TextView) convertView.findViewById(R.id.text_video_item_title);
            convertView.setTag(viewHodler);
        } else {
            viewHodler = (ViewHodler) convertView.getTag();
        }
        VideoInfor infor = mLists.get(position);
        viewHodler.mText_VideoTitle.setText(infor.videoTitle);
        return convertView;
    }

}
