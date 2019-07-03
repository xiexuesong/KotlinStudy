package com.example.admin.kotlinstudy

import android.content.Context
import android.content.Context.*
import android.hardware.input.InputManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

/**
 * kotlin不需要加 ;
 * 这点和Go语言是一样的
 */
class MainActivity : AppCompatActivity() {

    // 变量定义 变量名 : 变量对应的类
    private lateinit var editText : EditText //定义EditText变量
    private lateinit var inputMethodManager: InputMethodManager  //定义软键盘类
    private lateinit var textView : TextView //定义TextView
    private lateinit var constraintLayout : ConstraintLayout
    private lateinit var recycleView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        constraintLayout = findViewById(R.id.constraintLayout)
        editText.requestFocus()

        editText.addTextChangedListener(object  : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textView.text = s
                var str = s.toString()
                var strInt = str.toIntOrNull()
                strInt?.let { judgeInputCategory(it) }
            }
        })

        textView.setOnClickListener{
            Toast.makeText(this,"点击TextView",Toast.LENGTH_SHORT).show()
        }
        //线程
   /*     Thread{
            kotlin.run {
                Thread.sleep(1000)
                showInputManager()
            }
        }.start()*/

    }

    /**
     * 判断输入类型
     */
    fun judgeInputCategory(any : Any){
        when(any){
            any is Int -> Log.i("MDL","int类型")
            any is String -> Log.i("MDL","String类型")
            else -> Toast.makeText(this,"其他",Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 显示软键盘
     */
    fun showInputManager(){
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(0,InputMethodManager.HIDE_NOT_ALWAYS)
    }
}
