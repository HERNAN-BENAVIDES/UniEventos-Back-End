package co.edu.uniquindio.unieventosbackend.services;

import co.edu.uniquindio.unieventosbackend.repositories.PagoRepository;
import com.mercadopago.client.preference.PreferenceItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PagoService {

     @Autowired
     private PagoRepository pagoRepository;

     public String realizarPago() throws MPException {
          try {
               // Agrega credenciales
               MercadoPagoConfig.setAccessToken("TESTUSER1646149387");

               PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                       .id("item-ID-1234")
                       .title("Meu produto")
                       .description("Descrição do Item")
                       .quantity(1)
                       .unitPrice(new BigDecimal("75.76"))
                       .currencyId("BRL")
                       .build();

               List<PreferenceItemRequest> items = new ArrayList<>();
               items.add(itemRequest);


               PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest
                       .builder().success("https://www.youtube.com")
                       .pending("http://www.youtube.com")
                       .failure("http://www.youtube.com")
                       .build();

               List<PreferencePaymentMethodRequest> excludedPaymentMethods = new ArrayList<>();

               List<PreferencePaymentTypeRequest> excludedPaymentTypes = new ArrayList<>();


               PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                       .items(items)
                       .backUrls(backUrls)
                       .build();

               PreferenceClient client = new PreferenceClient();

               Preference preference = client.create(preferenceRequest);
               return preference.getId();
          }catch (MPException | MPApiException e){
               throw new MPException(e.getMessage());
          }

     }
}
