package lt.codeacademy.service;

import lt.codeacademy.model.ShareSummary;
import lt.codeacademy.service.impl.ShareServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class ShareServiceImplTest {
    @Mock
    private ShareServiceImpl shareServiceImpl;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shareShoppingList() throws Exception {
        ShareSummary test = new ShareSummary(12, 12, "test");
        when(shareServiceImpl.shareShoppingList(test)).thenReturn(test);
    }
}