#### 1. static 关键字 ： 共享

 static: 被声明为static之后，该成员可以在类创建之前被访问，并且不需要对象引用。

 java支持静态成员变量、静态方法、静态代码块、静态嵌套类。

> 静态是相对于动态的，动态是指Java程序在JVM上运行时，JVM会根据程序的需要动态创建对象并存储对象(分配内存)，对象使命结束后，对象会被垃圾回收器销毁，即内存回收由JVM统一管理并分配给其他新创建的对象；静态是指Java程序还没有运行时，JVM就会为加载的类分配空间存储被static关键字修饰的内容；如静态成员变量，Java类加载到JVM中，JVM会把类以及类的静态成员变量存储在方法区，我们知道方法区是线程共享且很少发生GC的区域，所以被static关键字修饰的内容都是全局共享的，且只会为其分配一次存储空间。

所以当类的某些内容不属于对象，而由对象共享即属于类的时候，就可以考虑是否用static关键字进行修饰。

Qs:

 1. 静态变量、静态代码块的加载顺序？jvm内存模型 







[https://www.geeksforgeeks.org/static-keyword-java/](https://www.geeksforgeeks.org/static-keyword-java/)

[https://zhuanlan.zhihu.com/p/73704288](https://zhuanlan.zhihu.com/p/73704288)



#### 2. 接口和抽象类





#### 3. jvm内存区域





