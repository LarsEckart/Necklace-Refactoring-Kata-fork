package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.NecklaceType;
import necklaceRefactoringKata.jewellery.PendantNecklace;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static necklaceRefactoringKata.JewelleryFactory.*;

class PackJewelleryTests {

    @Test
    void test_in_travel_roll() {
        CombinationApprovals.verifyAllCombinations(this::packItemToTravelRoll, allRingsPendantsNecklacesEarrings());
    }

    @Test
    void test_necklaces() {
        ArrayList<Necklace> necklaces = new ArrayList<>();
        necklaces.addAll(allNecklaces());
        necklaces.addAll(allPendantNecklaces());

        CombinationApprovals.verifyAllCombinations(this::packNecklace, necklaces.toArray(new Necklace[0]));
    }

    private String packNecklace(Necklace item) {
        var storage = new JewelleryStorage();

        Packer.packNecklace(item, storage);

        return StoragePrinter.print(storage);
    }

    @Test
    void test_jewellery() {
        CombinationApprovals.verifyAllCombinations(this::packItem, allRingsPendantsNecklacesEarrings());
    }

    @Test
    void test_pendantNecklace() {
        CombinationApprovals.verifyAllCombinations(this::packPendantNecklaces, Jewel.values(), NecklaceType.values(), necklaces(), allRingsPendantsNecklacesEarrings());
    }

    private String packPendantNecklaces(Jewel jewel, NecklaceType type, Necklace chain, Jewellery pendant) {
        var item = new PendantNecklace(jewel, type, chain, pendant);
        return packItem(item);
    }

    private String packItem(Jewellery item) {
        var storage = new JewelleryStorage();

        Packer.pack(item, storage);

        return StoragePrinter.print(storage);
    }

    private String packItemToTravelRoll(Jewellery item) {
        var storage = new JewelleryStorage();
        storage.travelRoll.add(item);

        Packer.pack(item, storage);

        return StoragePrinter.print(storage);
    }
}
