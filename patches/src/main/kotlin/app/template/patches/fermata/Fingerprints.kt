package app.template.patches.fermata

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.string

object DeviceLicenseFingerprints {

    /**
     * Matches the public static verify(Context, Consumer) method[cite: 1].
     */
    object VerifyFingerprint : Fingerprint(
        name = "verify",
        returnType = "V",
        filters = listOf(
            string("run_count")
        )
    )
}