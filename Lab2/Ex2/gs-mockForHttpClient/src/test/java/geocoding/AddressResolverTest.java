package geocoding;

import connection.ISimpleHttpClient;
import connection.TqsBasicHttpClient;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.management.BadAttributeValueExpException;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AddressResolverTest {
    @Mock ISimpleHttpClient httpclient;

    @Test
    void whenGoodAlboiGps_returnAddress() throws ParseException, IOException, URISyntaxException {
        //todo
        String s = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2021 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2021 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":40.640661,\"lng\":-8.656688}},\"locations\":[{\"street\":\"Cais do Alboi\",\"adminArea6\":\"\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Gl\\u00F3ria e Vera Cruz\",\"adminArea5Type\":\"City\",\"adminArea4\":\"\",\"adminArea4Type\":\"County\",\"adminArea3\":\"Centro\",\"adminArea3Type\":\"State\",\"adminArea1\":\"PT\",\"adminArea1Type\":\"Country\",\"postalCode\":\"3800-246\",\"geocodeQualityCode\":\"B1AAA\",\"geocodeQuality\":\"STREET\",\"dragPoint\":false,\"sideOfStreet\":\"N\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":\"s\",\"latLng\":{\"lat\":40.640524,\"lng\":-8.656713},\"displayLatLng\":{\"lat\":40.640524,\"lng\":-8.656713},\"mapUrl\":\"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.64052368145179,-8.656712986761146|marker-sm-50318A-1&scalebar=true&zoom=15&rand=1063335095\",\"roadMetadata\":null}]}]}";
        String url = "http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=40.640661%2C-8.656688&includeRoadMetadata=true";
        Mockito.when(httpclient.get(url)).thenReturn(s);


        //test
        AddressResolver resolver = new AddressResolver(httpclient);
        Address result = resolver.findAddressForLocation(40.640661, -8.656688);

        //return
        assertEquals( result, new Address( "Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null) );

    }

    @Test
    public void whenBadCoordidates_throwBadArrayindex() throws IOException, URISyntaxException, ParseException {

        AddressResolver resolver = new AddressResolver(httpclient);
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