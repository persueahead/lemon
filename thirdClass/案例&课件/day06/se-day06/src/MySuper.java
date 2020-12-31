import java.lang.annotation.Target;

//标识一个注解

public @interface MySuper {
	//没有带上值的
   String name();
   //也可以带上默认值‘  
   String values() default "同学都理解java";
   //也可以使用数组
   String[]  key();
}
