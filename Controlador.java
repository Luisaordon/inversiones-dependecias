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