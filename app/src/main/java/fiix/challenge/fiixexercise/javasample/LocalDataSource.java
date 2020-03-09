package fiix.challenge.fiixexercise.javasample;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import fiix.challenge.fiixexercise.dp.DataSource;

public class LocalDataSource implements DataSource {
    @NotNull
    @Override
    public List<String> getData() {
        return Arrays.asList(
                "7",
                "Dr. Seuss",
                "A Study in Scarlet",
                "88",
                "1986",
                "My Neighbor Totoro",
                "True",
                "San Fransokyo",
                "Camp Crystal Lake",
                "32",
                "10",
                "Crete"
        );
    }
}
