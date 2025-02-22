package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.freshmen.Address;
import seedu.address.model.freshmen.Email;
import seedu.address.model.freshmen.Freshmen;
import seedu.address.model.freshmen.Name;
import seedu.address.model.freshmen.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;


/**
 * A utility class to help with building Person objects.
 */
public class FreshmenBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;

    public FreshmenBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public FreshmenBuilder(Freshmen freshmenToCopy) {
        name = freshmenToCopy.getName();
        phone = freshmenToCopy.getPhone();
        email = freshmenToCopy.getEmail();
        address = freshmenToCopy.getAddress();
        tags = new HashSet<>(freshmenToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public FreshmenBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public FreshmenBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public FreshmenBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public FreshmenBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public FreshmenBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public Freshmen build() {
        return new Freshmen(name, phone, email, address, tags);
    }

}
