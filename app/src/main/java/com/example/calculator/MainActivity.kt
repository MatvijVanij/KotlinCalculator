package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit  var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener{setTextFilds("0")}
        btn_1.setOnClickListener{setTextFilds("1")}
        btn_2.setOnClickListener{setTextFilds("2")}
        btn_3.setOnClickListener{setTextFilds("3")}
        btn_4.setOnClickListener{setTextFilds("4")}
        btn_5.setOnClickListener{setTextFilds("5")}
        btn_6.setOnClickListener{setTextFilds("6")}
        btn_7.setOnClickListener{setTextFilds("7")}
        btn_8.setOnClickListener{setTextFilds("8")}
        btn_9.setOnClickListener{setTextFilds("9")}
        btn_minus.setOnClickListener{setTextFilds("-")}
        btn_plus.setOnClickListener{setTextFilds("+")}
        btn_mult.setOnClickListener{setTextFilds("*")}
        btn_div.setOnClickListener{setTextFilds("/")}
        btn_leftbunch.setOnClickListener{setTextFilds("(")}
        btn_rightbunch.setOnClickListener{setTextFilds(")")}

        btn_AC.setOnClickListener{clearTextFild()}

        btn_back.setOnClickListener{clearOneSymbol()}

        btn_equal.setOnClickListener{GetResult()}

    }

    fun clearOneSymbol(){
        var str = math_operation.text.toString()
        if (str.isNotEmpty())
            math_operation.text = str.substring(0,str.length - 1)
        result_text.text = ""
    }

    fun clearTextFild(){
        math_operation.text = ""
        result_text.text = ""
    }

    fun  setTextFilds(str: String){
        if(result_text.text != "")
            math_operation.text = result_text.text
            result_text.text = ""
      math_operation.append(str)
    }

    fun GetResult()
    {
        try {
            val ex = ExpressionBuilder(math_operation.text.toString()).build()
            val result = ex.evaluate()

            val longRes = result.toLong()
            if (result == longRes.toDouble())
                result_text.text = longRes.toString()
            else result_text.text = result.toString()

        }catch (e:Exception){
            Log.d("Ошибка","сообщение: ${e.message} ")

        }

    }
}