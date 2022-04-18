package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Earring;
import necklaceRefactoringKata.jewellery.EarringType;
import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.NecklaceType;
import necklaceRefactoringKata.jewellery.Pendant;
import necklaceRefactoringKata.jewellery.PendantNecklace;
import necklaceRefactoringKata.jewellery.Ring;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PackNecklaceTests {

    @Test
    void test_necklace() {
        CombinationApprovals.verifyAllCombinations(this::necklaces, Jewel.values(), NecklaceType.values());
    }

    @Test
    void test_earring() {
        CombinationApprovals.verifyAllCombinations(this::earrings, Jewel.values(), EarringType.values());
    }

    @Test
    void test_pendant() {
        CombinationApprovals.verifyAllCombinations(this::pendants, Jewel.values());
    }

    @Test
    void test_pendantNecklace() {
        CombinationApprovals.verifyAllCombinations(this::pendantNecklaces, Jewel.values(), NecklaceType.values(), allNecklaces(), allJewellery());
    }

    private Necklace[] allNecklaces() {
        var result = new ArrayList<>();
        for (Jewel jewel : Jewel.values()) {
            for (NecklaceType necklaceType : NecklaceType.values()) {
                result.add(new Necklace(jewel, necklaceType));
            }
        }
        return result.toArray(new Necklace[0]);
    }

    private Jewellery[] allJewellery() {
        var result = new ArrayList<>();
        for (Jewel jewel : Jewel.values()) {
            result.add(new Ring(jewel));
            result.add(new Pendant(jewel));
            for (NecklaceType necklaceType : NecklaceType.values()) {
                result.add(new Necklace(jewel, necklaceType));
            }
            for (EarringType earringType : EarringType.values()) {
                result.add(new Earring(jewel, earringType));
            }
        }
        return result.toArray(new Jewellery[0]);
    }

    @Test
    void test_ring() {
        CombinationApprovals.verifyAllCombinations(this::rings, Jewel.values());
    }

    private String necklaces(Jewel jewel, NecklaceType type) {
        var item = new Necklace(jewel, type);
        var storage = new JewelleryStorage();

        Packer.packNecklace(item, storage);

        return StoragePrinter.print(storage);
    }

    private String earrings(Jewel jewel, EarringType type) {
        var item = new Earring(jewel, type);
        var storage = new JewelleryStorage();

        Packer.pack(item, storage);

        return StoragePrinter.print(storage);
    }

    private String pendants(Jewel jewel) {
        var item = new Pendant(jewel);
        var storage = new JewelleryStorage();

        Packer.pack(item, storage);

        return StoragePrinter.print(storage);
    }

    private String pendantNecklaces(Jewel jewel, NecklaceType type, Necklace chain, Jewellery pendant) {
        var item = new PendantNecklace(jewel, type, chain, pendant);
        var storage = new JewelleryStorage();

        Packer.pack(item, storage);

        return StoragePrinter.print(storage);
    }

    private String rings(Jewel jewel) {
        var item = new Ring(jewel);
        var storage = new JewelleryStorage();

        Packer.pack(item, storage);

        return StoragePrinter.print(storage);
    }

}
