/*
 * Copyright 2016 Bjoern Bilger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jrestless.security;

import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_BIRTHDATE;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_EMAIL;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_EMAIL_VERIFIED;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_FAMILY_NAME;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_GENDER;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_GIVEN_NAME;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_LOCALE;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_MIDDLE_NAME;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_NAME;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_NICKNAME;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_PHONE_NUMBER;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_PHONE_NUMBER_VERIFIED;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_PICTURE;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_PREFERRED_USERNAME;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_PROFILE;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_UPDATED_AT;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_WEBSITE;
import static com.jrestless.security.OpenIdClaimFieldNames.STANDARD_CLAIM_ZONEINFO;

/**
 * OpenID standard claims.
 * <p>
 * See <a href=
 * "http://openid.net/specs/openid-connect-core-1_0.html#StandardClaims">
 * http://openid.net/specs/openid-connect-core-1_0.html#StandardClaims</a>
 *
 * @author Bjoern Bilger
 *
 */
public interface OpenIdStandardClaims extends Claims, OpenIdSubClaim {

	/**
	 * End-User's full name in displayable form including all name parts,
	 * possibly including titles and suffixes, ordered according to the
	 * End-User's locale and preferences.
	 */
	default String getName() {
		return (String) getAllClaims().get(STANDARD_CLAIM_NAME);
	}

	/**
	 * Given name(s) or first name(s) of the End-User. Note that in some
	 * cultures, people can have multiple given names; all can be present, with
	 * the names being separated by space characters.
	 */
	default String getGivenName() {
		return (String) getAllClaims().get(STANDARD_CLAIM_GIVEN_NAME);
	}

	/**
	 * Surname(s) or last name(s) of the End-User. Note that in some cultures,
	 * people can have multiple family names or no family name; all can be
	 * present, with the names being separated by space characters.
	 */
	default String getFamilyName() {
		return (String) getAllClaims().get(STANDARD_CLAIM_FAMILY_NAME);
	}

	/**
	 * Middle name(s) of the End-User. Note that in some cultures, people can
	 * have multiple middle names; all can be present, with the names being
	 * separated by space characters. Also note that in some cultures, middle
	 * names are not used.
	 */
	default String getMiddleName() {
		return (String) getAllClaims().get(STANDARD_CLAIM_MIDDLE_NAME);
	}

	/**
	 * Casual name of the End-User that may or may not be the same as the
	 * given_name. For instance, a nickname value of Mike might be returned
	 * alongside a given_name value of Michael.
	 */
	default String getNickname() {
		return (String) getAllClaims().get(STANDARD_CLAIM_NICKNAME);
	}

	/**
	 * Shorthand name by which the End-User wishes to be referred to at the RP,
	 * such as janedoe or j.doe. This value MAY be any valid JSON string
	 * including special characters such as @, /, or whitespace. The RP MUST NOT
	 * rely upon this value being unique, as discussed in <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#ClaimStability">Section
	 * 5.7</a>.
	 */
	default String getPreferredUsername() {
		return (String) getAllClaims().get(STANDARD_CLAIM_PREFERRED_USERNAME);
	}

	/**
	 * URL of the End-User's profile page. The contents of this Web page SHOULD
	 * be about the End-User.
	 */
	default String getProfile() {
		return (String) getAllClaims().get(STANDARD_CLAIM_PROFILE);
	}

	/**
	 * URL of the End-User's profile picture. This URL MUST refer to an image
	 * file (for example, a PNG, JPEG, or GIF image file), rather than to a Web
	 * page containing an image. Note that this URL SHOULD specifically
	 * reference a profile photo of the End-User suitable for displaying when
	 * describing the End-User, rather than an arbitrary photo taken by the
	 * End-User.
	 */
	default String getPicture() {
		return (String) getAllClaims().get(STANDARD_CLAIM_PICTURE);
	}

	/**
	 * URL of the End-User's Web page or blog. This Web page SHOULD contain
	 * information published by the End-User or an organization that the
	 * End-User is affiliated with.
	 */
	default String getWebsite() {
		return (String) getAllClaims().get(STANDARD_CLAIM_WEBSITE);
	}

	/**
	 * End-User's preferred e-mail address. Its value MUST conform to the
	 * <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#RFC5322">RFC
	 * 5322</a> &#91;RFC5322&#93; addr-spec syntax. The RP MUST NOT rely upon this value
	 * being unique, as discussed in Section <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#ClaimStability">5.7</a>.
	 */
	default String getEmail() {
		return (String) getAllClaims().get(STANDARD_CLAIM_EMAIL);
	}

	/**
	 * <b>Attention: returns null if the claim is not present</b>
	 * <p>
	 * True if the End-User's e-mail address has been verified; otherwise false.
	 * When this Claim Value is true, this means that the OP took affirmative
	 * steps to ensure that this e-mail address was controlled by the End-User
	 * at the time the verification was performed. The means by which an e-mail
	 * address is verified is context-specific, and dependent upon the trust
	 * framework or contractual agreements within which the parties are
	 * operating.
	 */
	default Boolean getEmailVerified() {
		return (Boolean) getAllClaims().get(STANDARD_CLAIM_EMAIL_VERIFIED);
	}

	/**
	 * End-User's gender. Values defined by this specification are female and
	 * male. Other values MAY be used when neither of the defined values are
	 * applicable.
	 */
	default String getGender() {
		return (String) getAllClaims().get(STANDARD_CLAIM_GENDER);
	}

	/**
	 * End-User's birthday, represented as an <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#ISO8601-2004">ISO
	 * 8601:2004</a> &#91;ISO8601‑2004&#93; YYYY-MM-DD format. The year MAY be 0000,
	 * indicating that it is omitted. To represent only the year, YYYY format is
	 * allowed. Note that depending on the underlying platform's date related
	 * function, providing just year can result in varying month and day, so the
	 * implementers need to take this factor into account to correctly process
	 * the dates.
	 */
	default String getBirthdate() {
		return (String) getAllClaims().get(STANDARD_CLAIM_BIRTHDATE);
	}

	/**
	 * String from zoneinfo <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#zoneinfo">&#91;zoneinfo&#93;</a>
	 * time zone database representing the End-User's time zone. For example,
	 * Europe/Paris or America/Los_Angeles.
	 */
	default String getZoneinfo() {
		return (String) getAllClaims().get(STANDARD_CLAIM_ZONEINFO);
	}

	/**
	 * End-User's locale, represented as a <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#RFC5646">BCP47</a>
	 * &#91;RFC5646&#93; language tag. This is typically an <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#ISO639-1">ISO 639-1
	 * Alpha-2</a> &#91;ISO639‑1&#93; language code in lowercase and an <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#ISO3166-1">ISO
	 * 3166-1 Alpha-2</a> &#91;ISO3166‑1&#93; country code in uppercase, separated by a
	 * dash. For example, en-US or fr-CA. As a compatibility note, some
	 * implementations have used an underscore as the separator rather than a
	 * dash, for example, en_US; Relying Parties MAY choose to accept this
	 * locale syntax as well.
	 */
	default String getLocale() {
		return (String) getAllClaims().get(STANDARD_CLAIM_LOCALE);
	}

	/**
	 * End-User's preferred telephone number. <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#E.164">E.164</a>
	 * &#91;E.164&#93; is RECOMMENDED as the format of this Claim, for example, +1 (425)
	 * 555-1212 or +56 (2) 687 2400. If the phone number contains an extension,
	 * it is RECOMMENDED that the extension be represented using the <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#RFC3966">RFC
	 * 3966</a> &#91;RFC3966&#93; extension syntax, for example, +1 (604)
	 * 555-1234;ext=5678.
	 */
	default String getPhoneNumber() {
		return (String) getAllClaims().get(STANDARD_CLAIM_PHONE_NUMBER);
	}

	/**
	 * <b>Attention: returns null if the claim is not present</b>
	 * <p>
	 * True if the End-User's phone number has been verified; otherwise false.
	 * When this Claim Value is true, this means that the OP took affirmative
	 * steps to ensure that this phone number was controlled by the End-User at
	 * the time the verification was performed. The means by which a phone
	 * number is verified is context-specific, and dependent upon the trust
	 * framework or contractual agreements within which the parties are
	 * operating. When true, the phone_number Claim MUST be in E.164 format and
	 * any extensions MUST be represented in RFC 3966 format.
	 */
	default Boolean getPhoneNumberVerified() {
		return (Boolean) getAllClaims().get(STANDARD_CLAIM_PHONE_NUMBER_VERIFIED);
	}

	/**
	 * End-User's preferred postal address. The value of the address member is a
	 * JSON <a href=
	 * "http://openid.net/specs/openid-connect-core-1_0.html#RFC4627">&#91;RFC4627&#93;</a>
	 * structure containing some or all of the members defined in Section 5.1.1.
	 */
	OpenIdAddressClaims getAddress();

	/**
	 * <b>Attention: returns null if the claim is not present</b>
	 * <p>
	 * Time the End-User's information was last updated. Its value is a JSON
	 * number representing the number of seconds from 1970-01-01T0:0:0Z as
	 * measured in UTC until the date/time.
	 */
	default Long getUpdatedAt() {
		return (Long) getAllClaims().get(STANDARD_CLAIM_UPDATED_AT);
	}
}
