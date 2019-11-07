package jp.techacademy.kinugawa.mikako.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    //ボタンタップでダイアログを表示
    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    //時刻の数字を入れる用
    var hour: Int = 0


    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
                //MainActivityクラスを与える
                this,

                //時刻を設定した時にonTimeSetメソッドが呼ばれる
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    Log.d("UI_PARTS", "$hour:$minute")


                    //hourプロパティをInt型にして代入
                    this.hour = hour.toInt()


                    if (this.hour >= 2 && this.hour <= 9) {
                        textView.text = "おはよう"
                    } else if (this.hour >= 10 && this.hour <= 17) {
                        textView.text = "こんにちは"
                    } else {
                        textView.text = "こんばんは"
                    }

                },
                13, 0, true)


        //showメソッドで表示
        timePickerDialog.show()
    }



}
