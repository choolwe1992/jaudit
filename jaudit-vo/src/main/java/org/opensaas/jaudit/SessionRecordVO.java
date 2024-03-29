/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE
 * You may obtain a copy of the License at
 *
 *   http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opensaas.jaudit;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the default implementation and persistence definition for
 * {@link SessionRecord}.
 * 
 */
@Entity
@Table(name = "session_records")
public class SessionRecordVO implements SessionRecordMutable {

    /**
     * Generated serial id.
     */
    private static final long serialVersionUID = 3453183849964023803L;

    private Date _endedTs;

    private String _id;

    private Date _startedTs;

    private AuditSubject _system;

    private String _systemAddress;

    private String _sessionId;

    private ResponsibleInformation _responsibleInformation;

    /**
     * {@inheritDoc}
     */
    @Column(name = "ended_ts")
    public Date getEndedTs() {
        return _endedTs;
    }

    /**
     * {@inheritDoc}
     */
    public void setEndedTs(final Date endedTs) {
        _endedTs = endedTs;
    }

    /**
     * {@inheritDoc}
     */
    @Id
    public String getId() {
        return _id;
    }

    /**
     * Sets the unique id for this record.
     * 
     * @see #getId()
     * 
     * @param id
     */
    public void setId(String id) {
        _id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Column(name = "started_ts")
    public Date getStartedTs() {
        return _startedTs;
    }

    /**
     * {@inheritDoc}
     */
    public void setStartedTs(final Date startedTs) {
        _startedTs = startedTs;
    }

    /**
     * {@inheritDoc}
     */
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "subjectId", column = @Column(name = "system_subject_id")),
            @AttributeOverride(name = "subjectType", column = @Column(name = "system_subject_type")),
            @AttributeOverride(name = "subjectDiscriminator", column = @Column(name = "system_subject_discriminator")) })
    public AuditSubject getSystem() {
        return _system;
    }

    /**
     * {@inheritDoc}
     */
    public void setSystem(final AuditSubject system) {
        _system = system;
    }

    /**
     * {@inheritDoc}
     */
    @Column(name = "system_address", length = 255)
    public String getSystemAddress() {
        return _systemAddress;
    }

    /**
     * {@inheritDoc}
     */
    public void setSystemAddress(final String systemAddress) {
        _systemAddress = systemAddress;
    }

    /**
     * {@inheritDoc}
     */
    @Column(name = "session_id", length = 255, nullable = false, unique = true)
    public String getSessionId() {
        return _sessionId;
    }

    /**
     * {@inheritDoc}
     */
    public void setSessionId(final String sessionId) {
        _sessionId = sessionId;
    }

    /**
     * {@inheritDoc}
     */
    @Embedded
    public ResponsibleInformation getResponsibleInformation() {
        return _responsibleInformation;
    }

    /**
     * {@inheritDoc}
     */
    public void setResponsibleInformation(
            final ResponsibleInformation responsibleInformation) {
        _responsibleInformation = responsibleInformation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        if (_sessionId == null) {
            return super.hashCode();
        }
        return _sessionId.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof SessionRecord)) {
            return false;
        }

        SessionRecord sr = (SessionRecord) o;
        if (_sessionId == null || sr.getSessionId() == null) {
            return false;
        }

        return _sessionId.equals(sr.getSessionId());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder buff = new StringBuilder(255);
        buff.append("SessionRecord[sessionId=");
        buff.append(_sessionId);
        buff.append(", started=");
        buff.append(_startedTs);
        buff.append(", ended=");
        buff.append(_endedTs);
        buff.append(", system=");
        buff.append(_systemAddress);
        buff.append(", id=");
        buff.append(_id);
        buff.append("]");
        return buff.toString();
    }
}
