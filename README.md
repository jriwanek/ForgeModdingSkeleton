# ForgeModdingSkeleton
Skeletons for building Forge mods

## Missing Features:
1) Ability to Push version to Mod
2) AT file specification and configuration
		useDepAts
3) Support Curse ChangeLog from String
4) Support Curse ChangeLog from Git Commits
5) Sonarqube & Jar Signing Support for Travis
6) Sonarqube & Jar Signing Support for CircleCI
7) Only supports the maven-publish plugin, not the kind DarkHax used.

## Known Bugs:
1) Source jar always generated
	makeObfSourceJar
2) Many versions hard-coded
3) If Jar isn't signed, forge will warn.

## Example TODO:
1) Model Registration
2) Recipes
3) Fluid
4) Fluid Block
