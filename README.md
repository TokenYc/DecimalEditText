# DecimalEditText
只能写小数的EditText，保留n位小数。
	
在xml中添加

	xmlns:dicimal="http://schemas.android.com/apk/res-auto"

	<com.example.cc.decimaltest.DecimalEditText
	        android:id="@+id/editText"
	        android:layout_width="200dp"
	        android:layout_height="wrap_content"
	        android:numeric="decimal" 
	        dicimal:decimal_num="3"
	        />

或者在代码中添加

	 editText.setDecimal(3);


不管通过哪种方式，一定要在xml中设置

	android:numeric="decimal" 