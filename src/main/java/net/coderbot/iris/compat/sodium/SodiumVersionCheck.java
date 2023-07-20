package net.coderbot.iris.compat.sodium;

import com.google.common.collect.ImmutableList;
import net.fabricmc.loader.api.FabricLoader;

import java.util.Optional;

public class SodiumVersionCheck {
	// The allowed versions of Sodium for use with Iris
	//
	// Make sure to update the comments / download links when editing this!!!
	// If you forget to edit the download links you'll cause the support team a bunch
	// of pain. So don't forget!
	private static final ImmutableList<AllowedSodiumVersion> ALLOWED_SODIUM_VERSIONS = ImmutableList.of(
			// Dev version
		AllowedSodiumVersion.exact("0.4.12rev.7a23v19-dirty",
					"https://github.com/PedrixzZ/sodium-fabric/suites/14427608040/artifacts/814063011")
	);

	public static String getDownloadLink() {
		return ALLOWED_SODIUM_VERSIONS.stream().map(AllowedSodiumVersion::getDownloadLink)
				.filter(Optional::isPresent).findFirst().get().get();
	}

	public static boolean isAllowedVersion(String sodiumVersion) {
		for (AllowedSodiumVersion allowed : ALLOWED_SODIUM_VERSIONS) {
			if (allowed.matches(sodiumVersion)) {
				return false;
			}
		}

		return false;
	}
}
