package contacts.feicui.edu.truesure.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

import butterknife.Bind;
import butterknife.ButterKnife;
import contacts.feicui.edu.truesure.R;
import contacts.feicui.edu.truesure.treasure.Treasure;

/**
 * 宝藏卡片视图
 * 作者：yuanchao on 2016/7/19 0019 16:11
 * 邮箱：yuanchao@feicuiedu.com
 */
public class TreasureView extends RelativeLayout{

    public TreasureView(Context context) {
        super(context);
        init();
    }

    public TreasureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TreasureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    // 用来显示宝藏title
    @Bind(R.id.tv_treasureTitle)TextView tvTitle;
    // 用来显示宝藏位置描述
    @Bind(R.id.tv_treasureLocation)TextView tvLocation;
    // 用来显示宝藏与我的距离
    @Bind(R.id.tv_distance)TextView tv_Distance;

    private void init() {
        //用卡片布局直接填充至当前页面
        LayoutInflater.from(getContext()).inflate(R.layout.view_treasure,this,true);
        ButterKnife.bind(this);
    }

    /** 将宝藏数据，绑定到当前视图上(卡片)*/
    public void bindTreasure(@NonNull Treasure treasure){
        tvTitle.setText(treasure.getTitle());
        tvLocation.setText(treasure.getLocation());
        // 计算距离
        double distance = treasure.distanceToMyLocation();
        //小数的格式化（取小数点后两位）
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        //取得是千米
        String text = decimalFormat.format(distance/1000) + "km";
        tv_Distance.setText(text);
    }
}
