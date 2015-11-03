package pack;

public class Srtah_kal {
	static double Str_sum, Vel_u, Stoim_oc, Pokaz_stoim, Stoim_im, Str_vipl;
	static String Name;
	/* Переменные типа double - с плавающей точкой. служат для представления чисел, имеющих дробную часть */
	/*static позволяет определять статические методы. Это такие методы, которые являются общими для класса, а не для
	отдельного объекта этого класса. Также они могут работать лишь со статическими полями класса.К статическим методам 
	и переменным можно обращаться через имя класса.*/

	public static void text_str_kal() {/*Класс text_str_kal, который доступен для любого файла из пакета pack */
		/*  Модификатор доступа public означает, что метод виден и доступен любому классу.
	    static означает, что не нужно создавать экземпляр(копию) объекта в памяти, чтобы использовать этот метод.
	    void означает, что метод не возвращает данных в программу, которая его вызвала.
	    Метод с пустыми скобками, это означает, что метод не имеет аргументов(параметров)
	    */
		if (Index.sistema_1_int==1){
			Name="действительной стоимости.";
		} else if (Index.sistema_2_int==1){ //если выбрана вторая система
			Str_sum = Double.parseDouble(Index.Str_sum_text.getText());
			Stoim_oc = Double.parseDouble(Index.Stoim_oc_text.getText());
			Name="пропорциональной ответственности.";
		} else if (Index.sistema_3_int==1){ // если выбрана третья система
			Str_sum = Double.parseDouble(Index.Str_sum_text.getText());
			Name="первого риска.                      ";
		} else if (Index.sistema_4_int==1){ // если выбрана четвертая система
			Pokaz_stoim = Double.parseDouble(Index.Pokaz_stoim_text.getText());
			Stoim_oc = Double.parseDouble(Index.Stoim_oc_text.getText());
			Name="дробной части.                      ";
		} else if (Index.sistema_5_int==1){ // если выбрана пятая система
			Stoim_im = Double.parseDouble(Index.Stoim_im_text.getText());
			Name="восстановительной стоимости";
		}
		Vel_u = Double.parseDouble(Index.Vel_u_text.getText());

		/* В переменную  записываются данные введеные пользователем в текстовое поле которое расположено в файле Index.
		Преобразование данных в тип Double. */

    	
	}

	public static void calc() {/*Класс, который доступен для любого файла из пакета pack */
		/*  Модификатор доступа public означает, что метод виден и доступен любому классу.
	    static означает, что не нужно создавать экземпляр(копию) объекта в памяти, чтобы использовать этот метод.
	    void означает, что метод не возвращает данных в программу, которая его вызвала.
	    Метод с пустыми скобками, это означает, что метод не имеет аргументов(параметров)
	    */
		
		if (Index.sistema_1_int==1){
			Str_vipl=Vel_u;
		} else if (Index.sistema_2_int==1){ //если выбрана вторая система
			Str_vipl=(Str_sum*Vel_u)/Stoim_oc;
		} else if (Index.sistema_3_int==1){ // если выбрана третья система
			if (Str_sum<Vel_u){Str_vipl=Str_sum;} else {Str_vipl=Vel_u;}			
		} else if (Index.sistema_4_int==1){ // если выбрана четвертая система
			if (Pokaz_stoim==Stoim_oc){
				if (Str_sum<Vel_u){Str_vipl=Str_sum;} else {Str_vipl=Vel_u;}
			} else {
			Str_vipl=(Pokaz_stoim*Vel_u)/Stoim_oc;}
		} else if (Index.sistema_5_int==1){ // если выбрана пятая система
			Str_vipl = Stoim_im;
		}
		
		//форматированный вывод
	    String Str_vipl_str = String.format("%.2f", Str_vipl);
	    /* String - указываем что переменная будет иметь строковый тип,
	     * Str_vipl_str - название новой переменной,
	     * String.format - преобразование переменной в строкой тип,
	     	%.2f - указываем что переменная будет отображать только 2 цифры после запятой,
	     	Str_vipl - переменная типа double, которую надо преобразовать в строковый тип
	     	 */
		
	    Result.Sist_label.setText(Name);
	    Result.Str_vipl_label.setText(Str_vipl_str);
	    /* Записываем строковые переменные в текстовые поля Sist_label.., которые расположены в файле Result */
		
	}	
}
