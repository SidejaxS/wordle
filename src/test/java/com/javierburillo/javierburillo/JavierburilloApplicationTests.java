package com.javierburillo.javierburillo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javierburillo.javierburillo.models.PalabraPorLetras;
import com.javierburillo.javierburillo.repositories.IPalabraRepo;
import com.javierburillo.javierburillo.services.IPalabraService;
import com.javierburillo.javierburillo.services.PalabrasService;

@SpringBootTest
class JavierburilloApplicationTests {
	@Autowired
    private IPalabraService palabrasService;
	@Autowired
    private IPalabraRepo repo;
    @BeforeEach
	@Test
    public void setUp() {
        ((PalabrasService) palabrasService).setRepo(new IPalabraRepo() {
            
            private List<PalabraPorLetras> palabras = Arrays.asList(
                    new PalabraPorLetras(false, 'a', 1, 1), 
                    new PalabraPorLetras(false, 'b', 2, 2), 
                    new PalabraPorLetras(false, 'c', 3, 3), 
                    new PalabraPorLetras(false, 'd', 4, 4), 
                    new PalabraPorLetras(false, 'd', 5, 5));
            private List<String> before = Arrays.asList("abcde", "bcdea", "cdeab", "deabc", "eabcd");
            private int tries = 5;

            @Override
            public List<PalabraPorLetras> getPalabras() {
                return palabras;
            }

            @Override
            public int getTries() {
                return tries;
            }

            @Override
            public void minusOneTry() {
                tries--;
            }

            @Override
            public List<String> getBefore() {
                return before;
            }

			@Override
			public void setPalabras(String string) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException("Unimplemented method 'setPalabras'");
			}

			@Override
			public void setTries(int i) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException("Unimplemented method 'setTries'");
			}
        });
    }



	@Test
	void contextLoads() {
	}
	
	
	
	@Test
	public void testCheckNull() {
		PalabrasService service = new PalabrasService();
		IPalabraRepo repo = mock(IPalabraRepo.class);
		service.repo = repo;
		when(repo.getTries()).thenReturn(0);
		assertNull(service.check("hello"));
	}
	
	
	@Test
	public void testGetBefore() {
		PalabrasService service = new PalabrasService();
		IPalabraRepo repo = mock(IPalabraRepo.class);
		service.repo = repo;
		List<String> expected = Arrays.asList("hello");
		when(repo.getBefore()).thenReturn(expected);
		List<String> actual = service.getBefore();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetWordByPos() {
		PalabrasService service = new PalabrasService();
		IPalabraRepo repo = mock(IPalabraRepo.class);
		service.repo = repo;
		List<String> before = Arrays.asList("hello", "world");
		when(repo.getBefore()).thenReturn(before);
		assertEquals("hello", service.getWordByPos(0));
		assertEquals("world", service.getWordByPos(1));
		assertNull(service.getWordByPos(-1));
		assertNull(service.getWordByPos(2));
	}


	@Test
    public void testGetAttempts() {
        int result = palabrasService.getAttempts();
        assertEquals(10, result);
    }
}