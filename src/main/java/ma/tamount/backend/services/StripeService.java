package ma.tamount.backend.services;

import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import ma.tamount.backend.models.requests.ChargeRequest;

public interface StripeService {

    Charge charge(ChargeRequest request);

    ChargeCreateParams createChargeParams(ChargeRequest request);
}
