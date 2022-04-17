package necklaceRefactoringKata;

import necklaceRefactoringKata.enums.Jewel;
import necklaceRefactoringKata.enums.NecklaceType;
import necklaceRefactoringKata.jewelleryTypes.Necklace;
import org.junit.jupiter.api.Test;

class PackNecklaceTests {
    @Test
    void test_AmberBeadsNecklace_IsPackedInTree() {
        var item = new Necklace(Jewel.Pearl, NecklaceType.Beads);
        var storage = new JewelleryStorage();

        Packer.packNecklace(item, storage);

        // TODO: check it packed it correctly
    }
}
