# JWebMP Font Awesome

[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.plugins/font-awesome)](https://central.sonatype.com/artifact/com.jwebmp.plugins/font-awesome)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Modular](https://img.shields.io/badge/Modular-JPMS-green)
![Angular](https://img.shields.io/badge/Angular-20-DD0031?logo=angular)
![TypeScript](https://img.shields.io/badge/TypeScript-5-3178C6?logo=typescript)

<!-- Tech icons row -->
![Font Awesome](https://img.shields.io/badge/Font%20Awesome-7.2.0-528DD7?logo=fontawesome)
![JWebMP](https://img.shields.io/badge/JWebMP-2.0-0A7)

Font Awesome Free icon integration for JWebMP with Angular 21. Provides type-safe access to Font Awesome's scalable vector icons with support for Free Solid and Free Brands icon sets.

Built on [Font Awesome 6](https://fontawesome.com/) · [Angular FontAwesome](https://github.com/FortAwesome/angular-fontawesome) · [JWebMP Core](https://jwebmp.com/) · JPMS module `com.jwebmp.plugins.fontawesome5` · Java 25+

**Version: 7.2.0** — Font Awesome Free integration with SVG rendering and TypeScript generation.

## Installation

```xml
<dependency>
  <groupId>com.jwebmp.plugins</groupId>
  <artifactId>font-awesome</artifactId>
  <version>2.0.0-RC4</version>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp.plugins:font-awesome:2.0.0-RC4")
```
</details>

### NPM Dependencies

The plugin automatically includes Font Awesome dependencies:

```json
{
  "dependencies": {
    "@fortawesome/fontawesome-svg-core": "^7.2.0",
    "@fortawesome/free-solid-svg-icons": "^7.2.0",
    "@fortawesome/free-brands-svg-icons": "^6.2.2",
    "@fortawesome/angular-fontawesome": "^4.0.0"
  }
}
```

## Features

- **2,000+ Free Icons** — Font Awesome Free icon library (Free Solid, Free Brands)
- **Type-Safe Java API** — Compile-time safety with Java enums for icons and styles
- **Multiple Icon Styles** — Solid and Brand styles included
- **SVG or Web Font** — Choose between SVG rendering or classic CSS web fonts
- **Icon Transformations** — Rotate, flip, scale, position with fluent API
- **Layering & Masking** — Combine multiple icons with layers and masks
- **Animation Effects** — Built-in spin, pulse, and custom animations
- **Sizing Options** — Preset sizes from xs to 10x, or custom sizing
- **Angular Integration** — Auto-loaded via Angular FontAwesome module
- **CRTP Fluent API** — Method chaining for icon configuration
- **Zero Configuration** — Auto-registered via ServiceLoader SPI

## Quick Start

### Prerequisites

- **Java 25 LTS** (required)
- **Maven 3.8+**
- **Node.js 18+** (for frontend builds)
- **Angular 21+** (auto-integrated via JWebMP)

### Basic Usage

```java
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles;

// Create a solid icon
FontAwesome icon = new FontAwesome(FontAwesomeStyles.Solid, FontAwesomeIcons.cog);

// Create icons using factory methods
FontAwesome solidIcon = IFontAwesome.createIcon(FontAwesomeIcons.cog, FontAwesomeStyles.Solid);
FontAwesome brandIcon = IFontAwesome.createIcon(FontAwesomeBrandIcons.github, FontAwesomeStyles.Brand);
```

### Advanced Usage with Transformations

```java
import com.jwebmp.plugins.fontawesome5.IFontAwesome;
import com.jwebmp.plugins.fontawesome5.options.*;

// Icon with transformations and styling
FontAwesome icon = IFontAwesome.createIcon(FontAwesomeIcons.cogs, FontAwesomeStyles.Regular);
icon.spin()
    .transform(FontAwesomeTransforms.Grow_3, FontAwesomeTransforms.Up_4)
    .setStyle(FontAwesomeStyles.Regular)
    .setSize(FontAwesomeSizes.$4x)
    .setIcon(FontAwesomeIcons.cogs);
```

### Icon Layering and Masking

```java
import com.jwebmp.plugins.fontawesome5.IFontAwesome;

// Create a masked icon (icon inside another icon)
FontAwesome maskedIcon = IFontAwesome.createMaskIcon(
    FontAwesomeIcons.cog, FontAwesomeStyles.Light,
    FontAwesomeIcons.comment_alt, FontAwesomeStyles.Regular
);
```

### Brand Icons

```java
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeBrandIcons;

// Use brand icons
FontAwesome githubIcon = new FontAwesome(FontAwesomeStyles.Brand, FontAwesomeBrandIcons.github);
FontAwesome twitterIcon = new FontAwesome(FontAwesomeStyles.Brand, FontAwesomeBrandIcons.twitter);
```

---

## Architecture

### Technology Stack

- **Backend**: Java 25 LTS, Maven, GuicedEE (IoC)
- **Frontend**: Angular 21, TypeScript, Font Awesome 7.2.0
- **Integration**: JWebMP Page Configurators, ServiceLoader SPI
- **Rendering**: SVG via angular-fontawesome or CSS Web Fonts
- **Module System**: JPMS with explicit dependencies

### Module Structure

```
src/main/java/com/jwebmp/plugins/fontawesome5/
├── FontAwesome.java                      # Main icon component
├── IFontAwesome.java                     # Icon factory interface
├── FontAwesomeLayers.java                # Icon layering container
├── FontAwesomeLayerText.java             # Text in icon layers
├── FontAwesomeLayerCounter.java          # Counter badges
├── FontAwesomeList.java                  # Icon lists
├── FontAwesomeSwapOnClick.java           # Click-based icon swap
├── config/
│   ├── FontAwesome5PageConfigurator.java # Auto-configuration
│   ├── FontAwesomeConfigOptions.java     # JS config options
│   └── FontAwesomeReferenceType.java     # SVG vs WebFont enum
├── icons/
│   ├── FontAwesomeIcons.java             # 6000+ icon enum
│   └── FontAwesomeBrandIcons.java        # Brand icons enum
└── options/
    ├── FontAwesomeStyles.java            # Icon styles (Solid, Regular, etc.)
    ├── FontAwesomeSizes.java             # Size presets (xs to 10x)
    ├── FontAwesomeTransforms.java        # Transformations (rotate, scale, etc.)
    ├── FontAwesomeFamily.java            # Icon font families
    └── FontAwesomeDisplayOptions.java    # Display configuration
```

### Font Awesome Icon Styles

| Style | Description | Availability | Java Enum |
|-------|-------------|--------------|-----------|
| **Solid** | Filled icons | Free | `FontAwesomeStyles.Solid` |
| **Brand** | Logo and brand icons | Free | `FontAwesomeStyles.Brand` |
| **Classic** | Classic style icons | Free | `FontAwesomeStyles.Classic` |

> **Note**: Additional icon styles (Regular, Light, Duotone, Thin, Sharp) are available in the separate Font Awesome Pro plugin.

### Icon Sizes

```java
FontAwesomeSizes.xs       // Extra small
FontAwesomeSizes.sm       // Small
FontAwesomeSizes.lg       // Large
FontAwesomeSizes.$1x      // 1x size
FontAwesomeSizes.$2x      // 2x size
FontAwesomeSizes.$3x      // 3x size
FontAwesomeSizes.$4x      // 4x size
FontAwesomeSizes.$5x      // 5x size
FontAwesomeSizes.$6x      // 6x size
FontAwesomeSizes.$7x      // 7x size
FontAwesomeSizes.$8x      // 8x size
FontAwesomeSizes.$9x      // 9x size
FontAwesomeSizes.$10x     // 10x size
```

### Transformations

```java
// Scaling
FontAwesomeTransforms.Grow_1 to Grow_16    // Grow icon
FontAwesomeTransforms.Shrink_1 to Shrink_16 // Shrink icon

// Positioning
FontAwesomeTransforms.Up_1 to Up_16        // Move up
FontAwesomeTransforms.Down_1 to Down_16    // Move down
FontAwesomeTransforms.Left_1 to Left_16    // Move left
FontAwesomeTransforms.Right_1 to Right_16  // Move right

// Rotation
FontAwesomeTransforms.Rotate_90            // Rotate 90 degrees
FontAwesomeTransforms.Rotate_180           // Rotate 180 degrees
FontAwesomeTransforms.Rotate_270           // Rotate 270 degrees

// Flipping
FontAwesomeTransforms.FlipHorizontal       // Flip horizontally
FontAwesomeTransforms.FlipVertical         // Flip vertically
FontAwesomeTransforms.FlipBoth             // Flip both directions
```

---

## API Reference

### FontAwesome Class

Main icon component extending `Italic<J>`:

```java
// Constructors
FontAwesome(FontAwesomeStyles style, IFontAwesomeIcon icon)
FontAwesome()

// Configuration Methods
J setStyle(FontAwesomeStyles style)
J setIcon(IFontAwesomeIcon icon)
J setSize(FontAwesomeSizes size)
J spin()
J pulse()
J transform(FontAwesomeTransforms... transforms)
```

### IFontAwesome Interface

Factory methods for creating icons:

```java
static FontAwesome createIcon(IFontAwesomeIcon icon, FontAwesomeStyles style)
static FontAwesome createMaskIcon(IFontAwesomeIcon foregroundIcon, FontAwesomeStyles foregroundStyle,
                                   IFontAwesomeIcon backgroundIcon, FontAwesomeStyles backgroundStyle)
```

### FontAwesomeLayers

Container for layered icons:

```java
FontAwesomeLayers layers = new FontAwesomeLayers();
layers.add(icon1);
layers.add(icon2);
layers.add(new FontAwesomeLayerText("Text"));
layers.add(new FontAwesomeLayerCounter("5"));
```

---

## Configuration

### Auto-Configuration via PageConfigurator

The plugin is automatically configured when present on the classpath:

```java
@TsDependency(value = "@fortawesome/fontawesome-svg-core", version = "^7.2.0")
@TsDependency(value = "@fortawesome/free-solid-svg-icons", version = "^7.2.0")
@TsDependency(value = "@fortawesome/free-brands-svg-icons", version = "^6.2.2")
@TsDependency(value = "@fortawesome/angular-fontawesome", version = "^4.0.0")
@NgBootModuleImport("FontAwesomeModule")
public class FontAwesome5PageConfigurator implements IPageConfigurator {
    // Auto-loaded via ServiceLoader SPI
}
```

### JavaScript Configuration Options

```java
// Configure Font Awesome JavaScript behavior
FontAwesome5PageConfigurator.getConfigOptions()
    .setKeepOriginalSource(true)
    .setNestSVG();
```

### Choose SVG or Web Font Rendering

```java
// Use SVG rendering (default, recommended)
FontAwesome5PageConfigurator.setFontAwesomeReferenceType(FontAwesomeReferenceType.SVG);

// Use CSS Web Font rendering (legacy)
FontAwesome5PageConfigurator.setFontAwesomeReferenceType(FontAwesomeReferenceType.WebFontCSS);
```

---

## Testing

### Run Unit Tests

```bash
mvn clean test
```

### Code Coverage Report

```bash
mvn clean test jacoco:report
# Open: target/site/jacoco/index.html
```

### Test Example

```java
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FontAwesomeTest {

    @Test
    public void testIconCreation() {
        FontAwesome icon = new FontAwesome(FontAwesomeStyles.Solid, FontAwesomeIcons.cog);
        assertNotNull(icon);
        assertEquals("fa-icon", icon.getTag());
    }

    @Test
    public void testIconFactory() {
        FontAwesome icon = IFontAwesome.createIcon(FontAwesomeIcons.user, FontAwesomeStyles.Solid);
        assertNotNull(icon);
    }
}
```

---

## Module Graph

```
com.jwebmp.plugins.fontawesome5
 ├── com.jwebmp.core              (JWebMP core)
 ├── com.jwebmp.plugins.angular   (Angular integration)
 ├── com.jwebmp.plugins.typescript.client (TypeScript generation)
 └── jakarta.validation           (Bean validation)
```

### Exported Packages

- `com.jwebmp.plugins.fontawesome5` — Core Font Awesome components
- `com.jwebmp.plugins.fontawesome5.config` — Configuration and page configurators
- `com.jwebmp.plugins.fontawesome5.icons` — Icon enums (2000+ free icons)
- `com.jwebmp.plugins.fontawesome5.options` — Styles, sizes, transforms, display options

---

## Documentation

### Core Resources

- **[Font Awesome 6 Docs](https://fontawesome.com/docs)** — Official Font Awesome documentation
- **[Angular Font Awesome](https://github.com/FortAwesome/angular-fontawesome)** — Angular component library
- **[Icon Gallery](https://fontawesome.com/icons)** — Browse 6000+ icons
- **[JWebMP Home](https://jwebmp.com/)** — JWebMP framework documentation

### Project Files

| File | Purpose |
|------|---------|
| `FontAwesome.java` | Main icon component |
| `IFontAwesome.java` | Factory interface for creating icons |
| `FontAwesomeIcons.java` | Enum with 2000+ free icon names |
| `FontAwesomeBrandIcons.java` | Brand and logo icons |
| `FontAwesome5PageConfigurator.java` | Auto-configuration |
| `pom.xml` | Maven build configuration |
| `module-info.java` | JPMS module descriptor |

---

## Common Use Cases

### Navigation Icons

```java
public class NavigationBar extends Div<NavigationBar> {
    public NavigationBar() {
        super();

        // Home icon
        add(IFontAwesome.createIcon(FontAwesomeIcons.home, FontAwesomeStyles.Solid));

        // User profile icon
        add(IFontAwesome.createIcon(FontAwesomeIcons.user, FontAwesomeStyles.Solid));

        // Settings icon
        add(IFontAwesome.createIcon(FontAwesomeIcons.cog, FontAwesomeStyles.Solid));
    }
}
```

### Loading Spinner

```java
public class LoadingSpinner extends Div<LoadingSpinner> {
    public LoadingSpinner() {
        super();

        FontAwesome spinner = IFontAwesome.createIcon(FontAwesomeIcons.spinner, FontAwesomeStyles.Solid);
        spinner.spin().setSize(FontAwesomeSizes.$2x);
        add(spinner);
    }
}
```

### Social Media Icons

```java
public class SocialLinks extends Div<SocialLinks> {
    public SocialLinks() {
        super();

        add(new FontAwesome(FontAwesomeStyles.Brand, FontAwesomeBrandIcons.github));
        add(new FontAwesome(FontAwesomeStyles.Brand, FontAwesomeBrandIcons.twitter));
        add(new FontAwesome(FontAwesomeStyles.Brand, FontAwesomeBrandIcons.linkedin));
    }
}
```

### Icon with Badge Counter

```java
public class NotificationIcon extends Div<NotificationIcon> {
    public NotificationIcon(int count) {
        super();

        FontAwesomeLayers layers = new FontAwesomeLayers();
        layers.add(IFontAwesome.createIcon(FontAwesomeIcons.bell, FontAwesomeStyles.Solid));
        layers.add(new FontAwesomeLayerCounter(String.valueOf(count)));
        add(layers);
    }
}
```

### Transformed Icon

```java
public class TransformedIcon extends Div<TransformedIcon> {
    public TransformedIcon() {
        super();

        FontAwesome icon = IFontAwesome.createIcon(FontAwesomeIcons.arrow_right, FontAwesomeStyles.Solid);
        icon.transform(FontAwesomeTransforms.Rotate_90, FontAwesomeTransforms.Grow_2);
        add(icon);
    }
}
```

---

## Security

This project takes security seriously.

**Key Security Features**:
- No external network calls (icons loaded from NPM packages)
- No secrets or credentials required (except Pro token for Pro features)
- SVG sanitization via angular-fontawesome
- OWASP Dependency-Check in CI/CD
- GitHub Dependabot enabled
- JSpecify null-safety annotations

**Pro Token Security**:
- Use the page configurator to configure the Pro token securely at application startup, preferably from environment variables

---

## Contributing

Contributions are welcome! Please follow these guidelines:

1. **Fork** the repository
2. **Create a feature branch** (`git checkout -b feature/my-feature`)
3. **Commit with clear messages** (`git commit -m "feat: add new icon transformation"`)
4. **Push to your fork** (`git push origin feature/my-feature`)
5. **Open a Pull Request**

### Code Standards

- **Java**: Follow JWebMP conventions (enum naming, proper null safety)
- **Tests**: JUnit 5, ≥80% coverage (Jacoco enforced)
- **Formatting**: Maven Spotless plugin enforced
- **Documentation**: Update README for new features

---

## Project Status

| Aspect | Status |
|--------|--------|
| **Version** | 7.2.0 / 2.0.0-RC4 |
| **Icons** | 2000+ Free |
| **Java** | 25 LTS (required) |
| **Build** | Passing |
| **License** | Apache 2.0 |
| **Maintenance** | Active |

---

## Links

- **GitHub Repository**: https://github.com/JWebMP/JWebMP
- **Maven Central**: https://mvnrepository.com/artifact/com.jwebmp.plugins/font-awesome
- **Font Awesome Home**: https://fontawesome.com/
- **Icon Gallery**: https://fontawesome.com/icons
- **Angular Font Awesome**: https://github.com/FortAwesome/angular-fontawesome
- **JWebMP Home**: https://jwebmp.com/

---

## License

Licensed under the [Apache License 2.0](LICENSE).

```
Copyright 2025 JWebMP Contributors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

---

## Acknowledgments

- **[Font Awesome](https://fontawesome.com/)** — The iconic SVG, font, and CSS framework
- **[Angular Font Awesome](https://github.com/FortAwesome/angular-fontawesome)** — Official Angular component
- **[JWebMP](https://jwebmp.com/)** — Server-driven web framework
- **[Angular](https://angular.dev/)** — Modern web framework

---

## Support

### For JWebMP-Specific Issues

- **GitHub Issues**: https://github.com/JWebMP/JWebMP/issues
- **Discussions**: https://github.com/JWebMP/JWebMP/discussions

### For Font Awesome Questions

- **Font Awesome Docs**: https://fontawesome.com/docs
- **Font Awesome Support**: https://fontawesome.com/support
- **Icon Search**: https://fontawesome.com/icons

---

**Made with JWebMP**
