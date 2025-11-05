# ejemplo del Principio de Inversión de Dependencias (DIP)

 Descripción

El Principio de Inversión de Dependencias (Dependency Inversion Principle - DIP) es el último de los principios SOLID.

## Este principio establece que:

Los módulos de alto nivel no deben depender de los módulos de bajo nivel, ambos deben depender de abstracciones.

En otras palabras, el código principal de un sistema no debería depender directamente de implementaciones concretas, sino de interfaces o abstracciones.
Esto permite que los detalles (como clases específicas) puedan cambiar sin afectar el funcionamiento general del sistema.

## Ejemplo sin aplicar DIP
class Motor {
    public void encender() {
        System.out.println("Motor encendido");
    }
}

class Controlador {
    private Motor motor = new Motor();

    public void iniciar() {
        motor.encender();
    }
}

# Problemas

La clase Controlador depende directamente de la clase Motor.

Si en el futuro se quiere usar otro tipo de motor (por ejemplo, un motor eléctrico o de gasolina), habría que modificar el código del controlador.

Esto genera un fuerte acoplamiento entre las clases y dificulta la escalabilidad y el mantenimiento del sistema.

## Ejemplo aplicando DIP
interface IMotor {
    void encender();
}

class MotorGasolina implements IMotor {
    public void encender() {
        System.out.println("Motor de gasolina encendido");
    }
}

class MotorElectrico implements IMotor {
    public void encender() {
        System.out.println("Motor eléctrico encendido");
    }
}

class Controlador {
    private IMotor motor;

    public Controlador(IMotor motor) {
        this.motor = motor;
    }

    public void iniciar() {
        motor.encender();
    }
}

## Explicación

Se crea una interfaz IMotor que define el método encender().
Esto representa una abstracción del concepto de “motor”.

Se crean las clases MotorGasolina y MotorElectrico, que implementan la interfaz IMotor.
Cada clase define su propio comportamiento para el método encender().

La clase Controlador ahora depende de la abstracción (IMotor) en lugar de depender de una implementación concreta.
El tipo de motor se inyecta mediante el constructor, lo que permite cambiarlo fácilmente.

De esta forma, se pueden agregar nuevos tipos de motor sin modificar el código del controlador.
Por ejemplo:

Controlador c1 = new Controlador(new MotorGasolina());
Controlador c2 = new Controlador(new MotorElectrico());

## Beneficios del DIP

🔹 Bajo acoplamiento: las clases están menos dependientes entre sí.

🔹 Alta flexibilidad: se pueden agregar o reemplazar implementaciones sin modificar el código existente.

🔹 Mejor mantenimiento: los cambios afectan menos partes del sistema.

🔹 Mayor escalabilidad: el software puede crecer sin comprometer su estructura.

## Conclusión

El Principio de Inversión de Dependencias (DIP) nos ayuda a construir sistemas más flexibles, mantenibles y escalables.
Al depender de abstracciones y no de implementaciones concretas, se logra un diseño más limpio, modular y preparado para el cambio.