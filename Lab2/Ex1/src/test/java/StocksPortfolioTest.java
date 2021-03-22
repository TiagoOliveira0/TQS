import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StocksPortfolioTest {

    @Mock
    IStockMarket market2;

    @InjectMocks
    StocksPortfolio portfolio2;

    @Test
    public void getTotalVolumeWithMocks() {

        // 1. Prepare a Mock to substitute the remote service (@Mock annotation)
        IStockMarket market = mock(IStockMarket.class);

        // 2. Create an instance of the subject under test (SuT) and use the mock to test the (remote) service instance
        StocksPortfolio portfolio = new StocksPortfolio( market );

        // 3. Load the mock with the proper expectations (when...thenReturn)
        when(market.getprice("EBAY")).thenReturn(4.0);
        when(market.getprice("MSFT")).thenReturn(1.5);

        // 4. Execute the test (use the service in the SuT)
        portfolio.addStock(new Stock("EBAY", 2));
        portfolio.addStock(new Stock("MSFT", 4));
        double result = portfolio.getTotalValue();

        // 5. Verify the result (assert) and the use of the mock
        assertEquals(14.0, result); // Junit
        assertThat(result, is(14.0)); // Hamcrest
        verify(market, times(2)).getprice(anyString());

    }

}
