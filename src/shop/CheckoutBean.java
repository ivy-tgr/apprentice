package shop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.ivyteam.ivy.environment.Ivy;

import java.io.Serializable;

@ManagedBean
@ViewScoped
public class CheckoutBean implements Serializable {

    private int activeStep = 0;

    public int getActiveStep() {
        return activeStep;
    }

    public void setActiveStep(int activeStep) {
        this.activeStep = activeStep;
    }

    public void onStepChange(int step) {
        this.activeStep = step;
    }
}
