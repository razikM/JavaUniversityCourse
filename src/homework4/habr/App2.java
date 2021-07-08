package homework4.habr;

public class App2 {
//
//
//2. Пессимистичный механизм
//
//
//    Я называю связь между проверяемыми исключениями и throws — «пессимистичной», польку мы можем «напугать» о большем, чем может произойти на самом деле, но не наоборот
//
//    Мы не можем бросать, но не предупредить
//    public class App {
//        public static void main(String[] args) {
//            throw new Exception(); // тут ошибка компиляции
//        }
//    }
//
//>> COMPILATION ERROR: unhandled exception: java.lang.Exception
//
//
//    Мы не можем бросать, но предупредить о «меньшем»
//            import java.io.IOException;
//
//    public class App {
//        public static void main(String[] args) throws IOException {
//            throw new Exception(); // тут ошибка компиляции
//        }
//    }
//
//>> COMPILATION ERROR: unhandled exception: java.lang.Exception
//
//
//    Мы можем предупредить точно о том, что бросаем
//    public class App {
//        public static void main(String[] args) throws Exception { // предупреждаем о Exception
//            throw new Exception(); // и кидаем Exception
//        }
//    }
//
//
//    Мы можем предупредить о большем, чем мы бросаем
//    public class App {
//        public static void main(String[] args) throws Throwable { // предупреждаем "целом" Throwable
//            throw new Exception(); // а кидаем только Exception
//        }
//    }
//
//
//    Можем даже предупредить о том, чего вообще нет
//    public class App {
//        public static void main(String[] args) throws Exception { // пугаем
//            // но ничего не бросаем
//        }
//    }
//
//
//    Даже если предупреждаем о том, чего нет — все обязаны бояться
//    public class App {
//        public static void main(String[] args) {
//            f(); // тут ошибка компиляции
//        }
//
//        public static void f() throws Exception {
//        }
//    }
//
//>> COMPILATION ERROR: unhandled exception: java.lang.Exception
//
//
//    Хотя они (испугавшиеся) могут перепугать остальных еще больше
//    public class App {
//        // они пугают целым Throwable
//        public static void main(String[] args) throws Throwable {
//            f();
//        }
//        // хотя мы пугали всего-лишь Exception
//        public static void f() throws Exception {
//        }
//    }
//
//
//    В чем цель «пессимистичности»? Все достаточно просто.
//    Вы в режиме протипирования «набросали», скажем, класс-утилиту для скачивания из интернета
//    public class InternetDownloader {
//    public static byte[] (String url) throws IOException {
//            return "<html><body>Nothing! It's stub!</body></html>".getBytes();
//        }
//    }
//
//    и хотели бы «принудить» пользователей вашего класса УЖЕ ОБРАБАТЫВАТЬ возможное исключение IOException, хотя из реализации-пустышки вы ПОКА НЕ ГЕНЕРИРУЕТЕ такое исключение. Но в будущем — собираетесь.
//
//
//3. throws с непроверяемым (unckecked) исключением
//
//    Вызов метода, который «пугает» unchecked исключением не накладывает на нас никаких обязанностей.
//    public class App {
//        public static void main(String[] args) {
//            f();
//        }
//        public static void f() throws RuntimeException {
//        }
//    }
//
//    Эта конструкция служит цели «указать» программисту-читателю кода на то, что ваш метод может выбросить некоторое непроверяемое (unchecked) исключение.
//
//    Пример (java.lang.NumberFormatException — непроверяемое исключение):
//            package java.lang;
//
//    public final class Integer extends Number implements Comparable<Integer> {
//    ...
//        /**
//         * ...
//         *
//         * @param s    a {@code String} containing the {@code int}
//         *             representation to be parsed
//         * @return     the integer value represented by the argument in decimal.
//         * @exception  NumberFormatException  if the string does not contain a
//         *               parsable integer.
//         */
//        public static int parseInt(String s) throws NumberFormatException {
//            return parseInt(s,10);
//        }
//    ...
//    }
//
//Integer.parseInt() может бросить unchecked NumberFormatException на неподходящем аргументе (int k = Integer.parseInt(«123abc»)), это отразили
//— в сигнатуре метода: throws NumberFormatException
//— в документации (javadoc): @ exception
//    но это ни к чему нас не обязывает.
//
//
//            4. Множественные исключения
//
//    Рассмотрим ситуацию с кодом, который может бросать проверяемые исключения разных типов.
//    Далее учитывайте, что EOFException и FileNotFoundException — потомки IOException.
//
//    Мы можем точно указать, что выбрасываем
//import java.io.EOFException;
//import java.io.FileNotFoundException;
//
//    public class App {
//        // пугаем ОБОИМИ исключениями
//        public static void main(String[] args) throws EOFException, FileNotFoundException {
//            if (System.currentTimeMillis() % 2 == 0) {
//                throw new EOFException();
//            } else {
//                throw new FileNotFoundException();
//            }
//        }
//    }
//
//    или вот так
//import java.io.EOFException;
//import java.io.FileNotFoundException;
//
//    public class App {
//        // пугаем ОБОИМИ исключениями
//        public static void main(String[] args) throws EOFException, FileNotFoundException {
//            f0();
//            f1();
//        }
//        public static void f0() throws EOFException {...}
//        public static void f1() throws FileNotFoundException {...}
//    }
//
//
//    А можем «испугать» сильнее (предком обоих исключений)
//import java.io.EOFException;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//    public class App {
//        // пугаем ПРЕДКОМ исключений
//        public static void main(String[] args) throws IOException {
//            if (System.currentTimeMillis() % 2 == 0) {
//                throw new EOFException();
//            } else {
//                throw new FileNotFoundException();
//            }
//        }
//    }
//
//    или вот так
//import java.io.EOFException;
//import java.io.FileNotFoundException;
//
//    public class App {
//        // пугаем ПРЕДКОМ исключений
//        public static void main(String[] args) throws IOException {
//            f0();
//            f1();
//        }
//        public static void f0() throws EOFException {...}
//        public static void f1() throws FileNotFoundException {...}
//    }
//
//
//    Можно и вот так: EOFException и FileNotFoundException «обобщаем до» IOException, а InterruptedException «пропускаем нетронутым» (InterruptedException — НЕ потомок IOException)
//            import java.io.EOFException;
//import java.io.FileNotFoundException;
//
//    public class App {
//        public static void main(String[] args) throws IOException, InterruptedException {
//            f0();
//            f1();
//            f2();
//        }
//        public static void f0() throws EOFException {...}
//        public static void f1() throws FileNotFoundException {...}
//        public static void f2() throws InterruptedException {...}
//    }
//
//
//
//5. Или catch, или throws
//
//    Не надо пугать тем, что вы перехватили
//    так
//    public class App {
//        public static void main(String[] args) {
//            try {
//                throw new Exception();
//            } catch (Exception e) {
//                // ...
//            }
//        }
//    }
//
//
//    или так (ставим catch по предку и точно перехватываем)
//    public class App {
//        public static void main(String[] args) {
//            try {
//                throw new Exception();
//            } catch (Throwable e) {
//                // ...
//            }
//        }
//    }
//
//
//    Но если перехватили только потомка, то не выйдет
//    public class App {
//        public static void main(String[] args) {
//            try {
//                throw new Throwable();
//            } catch (Exception e) {
//                // ...
//            }
//        }
//    }
//
//>> COMPILATION ERROR: unhandled exception: java.lang.Throwable
//
//
//    Не годится, естественно, и перехватывание «брата»
//    public class App {
//        public static void main(String[] args) {
//            try {
//                throw new Exception();
//            } catch (Error e) {
//                // ...
//            }
//        }
//    }
//
//>> COMPILATION ERROR: unhandled exception: java.lang.Exception
//
//
//    Если вы часть перехватили, то можете этим не пугать
//import java.io.EOFException;
//import java.io.FileNotFoundException;
//
//    public class App {
//        // EOFException перехватили catch-ом, им не пугаем
//        public static void main(String[] args) throws FileNotFoundException {
//            try {
//                if (System.currentTimeMillis() % 2 == 0) {
//                    throw new EOFException();
//                } else {
//                    throw new FileNotFoundException();
//                }
//            } catch (EOFException e) {
//                // ...
//            }
//        }
//    }
//
//
//
//6. Поведение компилятора/JVM
//
//    Необходимо понимать, что
//— проверка на cheched исключения происходит в момент компиляции (compile-time checking)
//— перехват исключений (catch) происходит в момент выполнения (runtime checking)
//    public class App {
//        // пугаем Exception
//        public static void main(String[] args) throws Exception {
//            Throwable t = new Exception(); // и лететь будет Exception
//            throw t; // но тут ошибка компиляции
//        }
//    }
//
//>> COMPILATION ERROR: unhandled exception: java.lang.Throwable
//
//
//    Полная аналогия с
//    public class App {
//        public static void main(String[] args) throws Exception {
//            Object ref = "Hello!";  // ref указывает на строку
//            char c = ref.charAt(0); // но тут ошибка компиляции
//        }
//    }
//
//>> COMPILATION ERROR: Cannot resolve method 'charAt(int)'
//
//    Хотя ССЫЛКА ref УКАЗЫВАЕТ на объект типа java.lang.String (у которого имеется метод charAt(int)), но ТИП ССЫЛКИ — java.lang.Object (ссылка типа java.lang.Object на объект типа java.lang.String). Компилятор ориентируется на «левый тип» (тип ссылки, а не тип ссылаемого) и не пропускает такой код.
//
//    Хотя В ДАННОЙ СИТУАЦИИ компилятор мог бы разобрать, что t ссылается на Exception, а ref — на String, но этого уже невозможно сделать при раздельно компиляции. Представьте, что мы МОГЛИ БЫ скомпилировать ОТДЕЛЬНО такой класс, упаковать в jar и распространять
//    // НЕ КОМПИЛИРУЕТСЯ! ИССЛЕДУЕМ ГИПОТЕТИЧЕСКУЮ СИТУАЦИЮ!
//    public class App {
//        public static void f0(Throwable t) throws Exception {
//            throw t;
//        }
//        public static void f1(Object ref){
//            char c = ref.charAt(0);
//        }
//    }
//
//
//    А кто-то берет этот класс, добавляет в classpath и вызывает App.f0(new Throwable()) или App.f1(new Integer(42)). В таком случае JVM столкнулась бы с ситуацией, когда от нее требует бросить проверяемое исключение, которое не отследил компилятор (в случае с f0) или вызвать метод, которого нет (в случае с f1)!
//
//    Java — язык со статической типизацией (т.е. отслеживание корректности использования типов (наличие используемых полей, наличие вызываемых методов, проверка на checked исключения, ...) проводится компилятором), запрещает такое поведение. В некоторых языках (языки с динамической типизацией — отслеживание корректности использования типов проводится средой исполнения (оно разрешено, например в JavaScript).
//
//    Компилятор не пропустит этот код, хотя метод main ГАРАНТИРОВАННО НЕ ВЫБРОСИТ ИСКЛЮЧЕНИЯ
//    public class App {
//        // пугаем Exception
//        public static void main(String[] args) throws Exception {
//            try {
//                Throwable t = new Exception(); // и лететь будет Exception
//                throw t; // но тут ошибка компиляции
//            } catch (Exception e) {
//                System.out.println("Перехвачено!");
//            }
//        }
//    }
//
//>> COMPILATION ERROR: unhandled exception: java.lang.Throwable
//
//
//    public class App {
//        // ТЕПЕРЬ пугаем Throwable
//        public static void main(String[] args) throws Throwable {
//            try {
//                Throwable t = new Exception(); // а лететь будет Exception
//                throw t;
//            } catch (Exception e) { // и мы перехватим Exception
//                System.out.println("Перехвачено!");
//            }
//        }
//    }
//
//>> Перехвачено!
//
//
//
//            7. Overriding и throws
//
//    При переопределении (overriding) список исключений потомка не обязан совпадать с таковым у предка.
//    Но он должен быть «не сильнее» списка предка:
//            import java.io.FileNotFoundException;
//import java.io.IOException;
//
//    public class Parent {
//        // предок пугает IOException и InterruptedException
//        public void f() throws IOException, InterruptedException {}
//    }
//
//    class Child extends Parent {
//        // а потомок пугает только потомком IOException
//        @Override
//        public void f() throws FileNotFoundException {}
//    }
//
//
//    Однако тут мы попытались «расширить тип» бросаемых исключений
//import java.io.IOException;
//
//    public class Parent {
//        public void f() throws IOException, InterruptedException {}
//    }
//
//    class ChildB extends Parent {
//        @Override
//        public void f() throws Exception {}
//    }
//
//>> COMPILATION ERROR: overridden method does not throw 'java.lang.Exception'
//
//
//    Почему можно сужать тип, но не расширять?
//    Рассмотрим следующую ситуацию:
//    public class Parent {
//        // предок пугает Exception
//        public void f() throws Exception {}
//    }
//
//
//    // тут ошибка компиляции в Java, но, ДОПУСТИМ, ее нет
//    public class Child extends Parent {
//        // потомок расширил Exception до Throwable
//        public void f() throws Throwable {}
//    }
//
//
//    public class Demo {
//        public static void test(Parent ref) {
//            // тут все компилируется, Parent.f() пугает Exception и мы его ловим catch
//            try {
//                ref.f();
//            } catch(Exception e) {}
//        }
//    }
//
//
//    public class App {
//        public static void main(String[] args) {
//            // тут все компилируется, Demo.test хотел Parent и мы дали ему подтип - Child
//            Demo.test(new Child());
//        }
//    }
}
