package app.template.patches.fermata

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.fermata.Constants.COMPATIBILITY_FERMATA
import app.template.patches.fermata.DeviceLicenseFingerprints.VerifyFingerprint

@Suppress("unused")
val licenseBypassPatch = bytecodePatch(
    name = "Bypass License Verification",
    description = "Bypasses Fermata Xtream license verification by forcing verify() to immediately accept Boolean.TRUE.",
    default = true
) {
    compatibleWith(COMPATIBILITY_FERMATA)

    execute {
        // verify(Context p0, Consumer p1) -> inject at start
        VerifyFingerprint.method.addInstructions(
            0,
            """
                sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;
                invoke-interface {p1, v0}, Ljava/util/function/Consumer;->accept(Ljava/lang/Object;)V
                return-void
            """
        )
    }
}