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

