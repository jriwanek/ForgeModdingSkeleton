# ForgeModdingSkeleton
Skeletons for building Forge mods

## Missing Features:
1) Support Curse ChangeLog from String
2) Sonarqube & Jar Signing Support for Travis
3) Sonarqube & Jar Signing Support for CircleCI
4) Secret parser should support Gradle properties too
5) Fix JUnit3, JUnit4 & JUnit Vintage compatibility (Should be done)
6) Support for JUnit on gradle < 4.6 (Effectively done, Will be on different branch)

## Known Caveats:
1) Many versions hard-coded
2) Only supports the maven-publish plugin, not the old maven plugin which also supports SSH Pubkey authentication

## Script related TODO
1) Document secret.json
2) Finish off JUnit5 feature set
3) Make sure JaCoCo is integrated correctly with JUnit

## Example Mod TODO:
1) Model Registration
2) Recipes
3) Fluid
4) Fluid Block
5) Seperation of concerns
6) Move EventHandlers
