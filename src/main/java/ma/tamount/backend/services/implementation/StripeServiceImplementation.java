package ma.tamount.backend.services.implementation;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.exceptions.CustomStripeException;
import ma.tamount.backend.services.StripeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ma.tamount.backend.models.requests.ChargeRequest;

/**
 * Implementation of the {@link StripeService} interface for handling payments with the Stripe API.
 * This service provides methods for charging users based on the provided {@link ChargeRequest}.
 *
 * @author Mohamed OSSALHE
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class StripeServiceImplementation implements StripeService {

    /**
     * The secret key for authenticating with the Stripe API.
     */
    @Value("${application.stripe.secret-key}")
    private static String secretKey;

    /**
     * initialize stripe api secret key on bean initialization
     */
    @PostConstruct
    public static void init() {
        Stripe.apiKey = secretKey;
    }

    /**
     * creates the Charge object used to request payment, and the Confirmation of the PaymentIntent
     * @param request The {@link ChargeRequest} containing details for the charge operation
     * @return object representing the result of the charge operation
     * @throws CustomStripeException If an error occurs during the Stripe API call.
     */
    @Override
    public Charge charge(ChargeRequest request) {
        try {
            ChargeCreateParams params = createChargeParams(request);
            return Charge.create(params);
        }catch(StripeException exception) {
            throw new CustomStripeException(exception.getMessage());
        }
    }

    /**
     * Creates a {@link ChargeCreateParams} Object for the Stripe charge based on the provided {@link ChargeRequest}.
     *
     * @param request The {@link ChargeRequest} containing details for the charge operation.
     * @return A {@link ChargeCreateParams} for the Stripe charge.
     */
    @Override
    public ChargeCreateParams createChargeParams(ChargeRequest request) {
        return ChargeCreateParams.builder()
                .setAmount(request.amount() * 100)
                .setCurrency(request.currency().toString())
                .setDescription(request.description())
                .setSource(request.token())
                .build();
    }
}