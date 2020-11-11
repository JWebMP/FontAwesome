package com.jwebmp.plugins.fontawesome5.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import jakarta.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
		getterVisibility = JsonAutoDetect.Visibility.NONE,
		setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class FontAwesomeConfigOptions<J extends FontAwesomeConfigOptions<J>>
		extends JavaScriptPart<J>
{

	/**
	 * CSS Pseudo-elements
	 * <p>
	 * We’ve seen a lot of examples where adding markup like i class="fas fa-user" allows you to easily add icons to any site. But what if
	 * changing the markup or HTML is not possible?
	 * <p>
	 * CSS has a powerful features known as Pseudo-elements. Font Awesome has leveraged the ::before pseudo-element to add icons to a page since the
	 * very beginning.
	 */
	private Boolean searchPseudoElements = false;

	/**
	 * Nest &lt;svg&gt; tags instead of replacing
	 * <p>
	 * There may be some cases where the replacement of the &lt;i&gt; tag is just not working out like you need it to.
	 * <p>
	 * You can configure Font Awesome to nest the &lt;svg&gt; within the &lt;i&gt; tag.
	 */
	private String autoReplaceSvg;

	/**
	 * Automatically add accessbility features like aria-hidden?
	 */
	private Boolean autoA11y = false;
	/**
	 * Insert the supporting CSS into the &lt;head&gt; of the HTML document?
	 */
	private Boolean autoAddCss = true;
	/**
	 * Class prefix for icons and CSS styles like fa-spin
	 */
	private String familyPrefix;
	/**
	 * If replacing with inline SVG keep an HTML comment with the original markup
	 */
	private Boolean keepOriginalSource = false;
	/**
	 * For supporting browsers, add markers in the Performance section of developer tools?
	 */
	private Boolean measurePerformance = false;
	/**
	 * Watch the DOM for any changes and add, replace, or modify icons on-the-fly
	 */
	private Boolean observeMutations = false;
	/**
	 * Main CSS class for &lt;svg&gt; tags replacements. All replacements will have this class.
	 */
	private String replacementClass;
	/**
	 * If an icon cannot be found show an animated “missing? icon in its place
	 */
	private Boolean showMissingIcons = true;

	public FontAwesomeConfigOptions()
	{
		//No config required
	}

	/**
	 * CSS Pseudo-elements
	 * * <p>
	 * * We’ve seen a lot of examples where adding markup like i class="fas fa-user" allows you to easily add icons to any site. But what if
	 * * changing the markup or HTML is not possible?
	 * * <p>
	 * * CSS has a powerful features known as Pseudo-elements. Font Awesome has leveraged the ::before pseudo-element to add icons to a page since
	 * the
	 * * very beginning.
	 *
	 * @return
	 */
	public Boolean getSearchPseudoElements()
	{
		return searchPseudoElements;
	}

	/**
	 * CSS Pseudo-elements
	 * * <p>
	 * * We’ve seen a lot of examples where adding markup like i class="fas fa-user" allows you to easily add icons to any site. But what if
	 * * changing the markup or HTML is not possible?
	 * * <p>
	 * * CSS has a powerful features known as Pseudo-elements. Font Awesome has leveraged the ::before pseudo-element to add icons to a page since
	 * the
	 * * very beginning.
	 *
	 * @param searchPseudoElements
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearchPseudoElements(Boolean searchPseudoElements)
	{
		this.searchPseudoElements = searchPseudoElements;
		return (J) this;
	}

	/**
	 * Nest &lt;svg&gt; tags instead of replacing
	 * <p>
	 * There may be some cases where the replacement of the &lt;i&gt; tag is just not working out like you need it to.
	 * <p>
	 * You can configure Font Awesome to nest the &lt;svg&gt; within the &lt;i&gt; tag.
	 *
	 * @return
	 */
	public String getAutoReplaceSvg()
	{
		return autoReplaceSvg;
	}

	/**
	 * Nest &lt;svg&gt; tags instead of replacing
	 * <p>
	 * There may be some cases where the replacement of the &lt;i&gt; tag is just not working out like you need it to.
	 * <p>
	 * You can configure Font Awesome to nest the &lt;svg&gt; within the &lt;i&gt; tag.
	 *
	 * @param autoReplaceSvg
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setAutoReplaceSvg(String autoReplaceSvg)
	{
		this.autoReplaceSvg = autoReplaceSvg;
		return (J) this;
	}

	/**
	 * true	Insert the supporting CSS into the &lt;head&gt; of the HTML document?
	 *
	 * @return
	 */
	public Boolean getAutoAddCss()
	{
		return autoAddCss;
	}

	/**
	 * true	Insert the supporting CSS into the &lt;head&gt; of the HTML document?
	 *
	 * @param autoAddCss
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setAutoAddCss(Boolean autoAddCss)
	{
		this.autoAddCss = autoAddCss;
		return (J) this;
	}

	/**
	 * Class prefix for icons and CSS styles like fa-spin
	 *
	 * @return
	 */
	public String getFamilyPrefix()
	{
		return familyPrefix;
	}

	/**
	 * Class prefix for icons and CSS styles like fa-spin
	 *
	 * @param familyPrefix
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setFamilyPrefix(String familyPrefix)
	{
		this.familyPrefix = familyPrefix;
		return (J) this;
	}

	/**
	 * If replacing with inline SVG keep an HTML comment with the original markup
	 *
	 * @return
	 */
	public Boolean getKeepOriginalSource()
	{
		return keepOriginalSource;
	}

	/**
	 * If replacing with inline SVG keep an HTML comment with the original markup
	 *
	 * @param keepOriginalSource
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setKeepOriginalSource(Boolean keepOriginalSource)
	{
		this.keepOriginalSource = keepOriginalSource;
		return (J) this;
	}

	/**
	 * For supporting browsers, add markers in the Performance section of developer tools?
	 *
	 * @return
	 */
	public Boolean getMeasurePerformance()
	{
		return measurePerformance;
	}

	/**
	 * For supporting browsers, add markers in the Performance section of developer tools?
	 *
	 * @param measurePerformance
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setMeasurePerformance(Boolean measurePerformance)
	{
		this.measurePerformance = measurePerformance;
		return (J) this;
	}

	/**
	 * Watch the DOM for any changes and add, replace, or modify icons on-the-fly
	 *
	 * @return
	 */
	public Boolean getObserveMutations()
	{
		return observeMutations;
	}

	/**
	 * Watch the DOM for any changes and add, replace, or modify icons on-the-fly
	 *
	 * @param observeMutations
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setObserveMutations(Boolean observeMutations)
	{
		this.observeMutations = observeMutations;
		return (J) this;
	}

	/**
	 * Main CSS class for svg tags replacements. All replacements will have this class.
	 *
	 * @return
	 */
	public String getReplacementClass()
	{
		return replacementClass;
	}

	/**
	 * Main CSS class for svg tags replacements. All replacements will have this class.
	 *
	 * @param replacementClass
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setReplacementClass(String replacementClass)
	{
		this.replacementClass = replacementClass;
		return (J) this;
	}

	/**
	 * If an icon cannot be found show an animated “missing? icon in its place
	 *
	 * @return
	 */
	public Boolean getShowMissingIcons()
	{
		return showMissingIcons;
	}

	/**
	 * If an icon cannot be found show an animated “missing? icon in its place
	 *
	 * @param showMissingIcons
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setShowMissingIcons(Boolean showMissingIcons)
	{
		this.showMissingIcons = showMissingIcons;
		return (J) this;
	}

	/**
	 * Automatically add accessbility features like aria-hidden?
	 *
	 * @return
	 */
	public Boolean getAutoA11y()
	{
		return autoA11y;
	}

	/**
	 * Automatically add accessbility features like aria-hidden?
	 *
	 * @param autoA11y
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setAutoA11y(Boolean autoA11y)
	{
		this.autoA11y = autoA11y;
		return (J) this;
	}

	/**
	 * Shortcut to set the SVG to nest inside the I tag
	 *
	 * @return
	 */
	public J setNestSVG()
	{
		return setAutoReplaceSvg("nest");
	}


}
