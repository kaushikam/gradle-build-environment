rootProject.name = "build-environment"

buildCache {
	local(DirectoryBuildCache::class.java) {
		directory = File(rootDir, "build-cache")
		removeUnusedEntriesAfterDays = 30
	}
}
