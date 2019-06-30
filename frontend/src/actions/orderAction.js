import {SET_MAX_STEP, SET_STEP} from "./actions";

const _setStep = (activeStep) => {
  return {
    type: SET_STEP,
    activeStep
  }
};