package evan.chen.tutorial.facebooklikebutton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isLike = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        like.setOnClickListener {
            //步驟1：變換照片
            if (isLike) {
                //將讚取消
                like.setImageResource(R.mipmap.fblike_notselect)
            } else {
                //按讚
                like.setImageResource(R.mipmap.fblike_select)
            }

            //新增一個動畫集合
            val animSet = AnimationSet(true)

            //步驟2：放大1.2倍的動畫
            val animation = ScaleAnimation(
                    1.0f,// x起始縮放比例
                    1.2f, // x結束縮放比例
                    1.0f,// x起始縮放比例
                    1.2f, // y結束縮放比例
                    Animation.RELATIVE_TO_SELF, 1f,
                    Animation.RELATIVE_TO_SELF, 1f)
            animation.duration = 200

            //步驟3：旋轉-20動畫的動畫
            val rotateAnimation = RotateAnimation(
                    0.0f, //起始角度
                    -20f, //結束角度
                    RotateAnimation.RELATIVE_TO_SELF, //pivotXType
                    0.5f, //設定x旋轉中心點
                    RotateAnimation.RELATIVE_TO_SELF,
                    0.5f) //設定y旋轉中心點

            //動畫持續時間
            rotateAnimation.duration = 200

            //將放大及旋轉的動畫放入動畫集合
            animSet.addAnimation(animation)
            animSet.addAnimation(rotateAnimation)

            //步驟4：開始動畫
            this.like.startAnimation(animSet)
            isLike = !isLike
        }
    }
}
