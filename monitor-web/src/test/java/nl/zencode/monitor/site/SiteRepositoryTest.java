package nl.zencode.monitor.site;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

/**
 * Unit test for SiteRepository.
 * @author Koert Zeilstra
 */
@RunWith(MockitoJUnitRunner.class)
public class SiteRepositoryTest {

    @InjectMocks private SiteRepository siteRepository;

    /**
     * Test getAllSites().
     */
    @Test
    public void getAllSites() {
        List<Site> allSites = siteRepository.getAllSites();
        Assert.assertThat(allSites.size(), is(3));

    }

}