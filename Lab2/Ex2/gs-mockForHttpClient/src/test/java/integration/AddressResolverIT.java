package integration;

import connection.TqsBasicHttpClient;
import geocoding.Address;
import geocoding.AddressResolver;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressResolverIT {


    @BeforeEach
    public void init(){
    }

     @Test
     void whenGoodAlboiGps_returnAddress() throws ParseException, IOException, URISyntaxException {
         //test
         AddressResolver resolver = new AddressResolver(new TqsBasicHttpClient());
         Address result = resolver.findAddressForLocation(40.640661, -8.656688);

         //return
         assertEquals( result, new Address( "Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null) );

     }

    @Test
    public void whenBadCoordidates_throwBadArrayindex() throws IOException, URISyntaxException, ParseException {

        AddressResolver resolver = new AddressResolver(new TqsBasicHttpClient());
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Address result = resolver.findAddressForLocation(91,-0);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Address result = resolver.findAddressForLocation(91,-181);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Address result = resolver.findAddressForLocation(89,-181);
        });

    }

    @Test
    public void nullUrl_throwsNullPointerException() throws IOException, URISyntaxException, ParseException {
        Assertions.assertThrows(NullPointerException.class, () ->{
            new TqsBasicHttpClient().get(null);
        });

    }


}
