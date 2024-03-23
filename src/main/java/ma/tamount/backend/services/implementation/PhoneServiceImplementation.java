package ma.tamount.backend.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.mappers.PhoneMapper;
import ma.tamount.backend.models.entities.Phone;
import ma.tamount.backend.models.requests.PhoneRequest;
import ma.tamount.backend.models.responses.PhoneResponse;
import ma.tamount.backend.repositories.PhoneRepository;
import ma.tamount.backend.services.PhoneService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

/**
 * Service class for managing phone-related operations.
 *
 * <p>This service class provides methods for retrieving phone data based on various criteria.</p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class PhoneServiceImplementation extends AbstractService<UUID, PhoneRequest, PhoneResponse, Phone, PhoneRepository, PhoneMapper> implements PhoneService {
}
