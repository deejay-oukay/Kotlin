package seminars.s4.task4;

import java.util.Scanner;

//Имеются три файла .java
//https://gist.github.com/avereshchagin/01f57dc90615829f42ec17313c4ec682
//Необходимо переписать класс ComplexNumber на Kotlin таким образом, чтобы
//   в остальных Java классах было минимум изменений и выполнялись условия:
//1. Создавать новый экземпляр ComplexNumber всё так же можно через
//   вызов ComplexNumber.create.
//2. Методы abs и div преобразовать в функции-расширения.
//3. Явно указать, что функция div бросает исключение
//   DivisionByZeroException.
public class JavaToKotlinTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first complex number");
        ComplexNumber a = ComplexNumber.create(
                scanner.nextDouble(), scanner.nextDouble()
        );
        System.out.println("Enter second complex number");
        ComplexNumber b = ComplexNumber.create(
                scanner.nextDouble(), scanner.nextDouble()
        );

        ComplexNumber c;
        try {
            c = ComplexNumberKt.div(a, b);
        } catch (DivisionByZeroException e) {
            System.out.println("Cannot divide by zero!");
            return;
        }

        double abs = ComplexNumberKt.abs(c);
        System.out.println(
                "first / second = " + c.re + " + " + c.im + "i"
        );
        System.out.println("|first / second| = " + abs);
    }
}
